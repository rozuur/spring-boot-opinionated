
CREATE TABLE IF NOT EXISTS movieEntity (
    id SERIAL PRIMARY KEY,

    title VARCHAR(1024),
    director VARCHAR(1024),
    release_date DATE NOT NULL DEFAULT current_date
);

INSERT INTO movieEntity(title, director, release_date)
VALUES
       ('The Shawshank Redemption', 'Frank Darabont', PARSEDATETIME('14 Oct 1994', 'dd MMM yyyy')),
       ('The Godfather', 'Francis Ford Coppola', PARSEDATETIME('24 Mar 1972', 'dd MMM yyyy'));