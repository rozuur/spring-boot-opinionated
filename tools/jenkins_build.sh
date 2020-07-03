#!/bin/bash

set -euox pipefail
IFS=$'\n\t'
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
readonly SCRIPT_DIR

readonly DOCKER_REPO=nexus.rozuur.com/repository/docker
# Jenkins job should be configured with boolean parameter 'RELEASE'
readonly RELEASE=${RELEASE:false}

function die() {
  echo "$*" 1>&2
  exit 1
}

function mvn() {
  command mvn --batch-mode "$@"
}

function perform_release() {
  # Clean and format the code, if there are changes build will fail when preparing release
  mvn clean fmt:format
  # Uses maven releaes plugin to upgrade project version and create git tags
  # release:prepare also executes 'clean verify' goals
  mvn release:clean release:prepare
}

function just_verify() {
  mvn clean verify
}

function deploy_artifacts() {
  local build_version=${1?Build version is required}
  local app_name=${2?Build version is required}
  # TODO use groupname and change the deploy jobs accordingly
  local image_name="${DOCKER_REPO}/${app_name}:${build_version}"
  docker build -t "${image_name}" .
  docker push "${image_name}"
  docker rmi "$(docker images --format '{{.Repository}}:{{.Tag}}' | grep ${app_name})"
}

function validate_release_state() {
  if [[ "${USER}" != "jenkins" ]]; then
    die "Release only happens on jenkins"
  fi
  if [[ "${GIT_BRANCH}" != "master" ]]; then
    die "Release can only happen with master branch"
  fi
}

function main() {
  if [[ "${USER}" != "jenkins" ]]; then
    die "Only runs on jenkins"
  fi

  local build_version
  build_version="$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout | sed 's/-SNAPSHOT//')"
  local app_name
  app_name="$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)"

  mvn --update-snapshots dependency:go-offline
  if [[ "${RELEASE}" == "true" ]]; then
    validate_release_state
    perform_release
    deploy_artifacts "${build_version}" "${app_name}"
  else
    just_verify
  fi
}

(
  cd "${SCRIPT_DIR}/.."
  main
)
