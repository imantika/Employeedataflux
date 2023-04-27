package com.itElites.employeeFlux.exceptionhandlers;

public class Exception extends RuntimeException{
public Exception(String message, Throwable cause) {
        super(message, cause);
        }

public Exception(String message){
        super(message);
        }
}
