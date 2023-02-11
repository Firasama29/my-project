package com.project.content.controller.advice;

import com.project.content.controller.BlogsController;
import com.project.content.controller.ProjectController;
import com.project.content.controller.TopicsController;
import com.project.content.controller.WebsitesController;
import com.project.content.exception.ContentErrorResponse;
import com.project.content.exception.InvalidArgumentException;
import com.project.content.exception.ResourceAlreadyExistsException;
import com.project.content.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(assignableTypes = { ProjectController.class, TopicsController.class, BlogsController.class, WebsitesController.class })
public class ContentControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ContentErrorResponse> handleResourceNotFound(ResourceNotFoundException exception) {
        ContentErrorResponse errorResponse = new ContentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ContentErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException exception) {
        ContentErrorResponse errorResponse = new ContentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ContentErrorResponse> handleInvalidArgumentError(InvalidArgumentException exception) {
        ContentErrorResponse errorResponse = new ContentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}