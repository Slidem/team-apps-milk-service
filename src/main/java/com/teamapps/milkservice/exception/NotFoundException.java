package com.teamapps.milkservice.exception;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
