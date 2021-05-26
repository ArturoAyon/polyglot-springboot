package com.polyglot.services;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class Asserts {

    public void resourceExists(Object resource, String message){
        if(resource == null){
            throw new ResourceNotFoundException(message);
        }
    }
}
