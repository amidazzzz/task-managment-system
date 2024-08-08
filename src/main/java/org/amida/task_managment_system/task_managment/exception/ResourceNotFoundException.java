package org.amida.task_managment_system.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
