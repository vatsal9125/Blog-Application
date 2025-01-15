package com.vatsal.blog.exceptions;

import lombok.RequiredArgsConstructor;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not found with specified ID");
    }
}
