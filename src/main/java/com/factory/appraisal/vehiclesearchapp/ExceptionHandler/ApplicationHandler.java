package com.factory.appraisal.vehiclesearchapp.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandler  {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException ex){
        Map<String, String> errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{errorMap.put(error.getField(),
                error.getDefaultMessage());});
        return errorMap;
    }

}


