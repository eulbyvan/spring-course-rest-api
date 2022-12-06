package com.eulbyvan.model.exception;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("gaada datanya bang");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
