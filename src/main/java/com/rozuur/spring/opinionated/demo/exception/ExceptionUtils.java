package com.rozuur.spring.opinionated.demo.exception;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

public class ExceptionUtils {

    public static Supplier<EntityNotFoundException> notFoundId(Class<?> clazz, Object id) {
        String msg = generateMessage(clazz, Collections.singletonMap("id", id.toString()));
        return () -> new EntityNotFoundException(msg);
    }

    private static String generateMessage(Class<?> clazz, Map<String, String> searchParams) {
        return clazz.getSimpleName() + " was not found for parameters " + searchParams;
    }
}
