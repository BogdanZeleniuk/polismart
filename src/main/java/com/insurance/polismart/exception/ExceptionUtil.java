package com.insurance.polismart.exception;

public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static <T> T checkNotFound(T object) {
        checkNotFound(object != null);
        return object;
    }

    public static void checkNotFound(boolean found) {
        if (!found) {
            throw new NotFoundException("Not found entity with");
        }
    }
}
