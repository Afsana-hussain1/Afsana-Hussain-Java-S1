package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> validationError(MethodArgumentNotValidException e, WebRequest request) {
        // BindingResult holds the validation errors
        BindingResult result = e.getBindingResult();
        // Validation errors are stored in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Translate the FieldErrors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        // Wrap all of the VndError objects in a VndErrors object
        VndErrors vndErrors = new VndErrors(vndErrorList);

        // Create and return the ResponseEntity
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }


    @ExceptionHandler(value = {JsonParseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> badRequest(JsonParseException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
    @ExceptionHandler(value = {ServerError.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<VndErrors> badResponse(ServerError e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(value = {JsonMappingException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> badRequestOutOfRange(JsonMappingException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> numberFormatException(NumberFormatException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "Parameter must be a whole number. " + e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {DataAccessException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> dataAccessException(DataAccessException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "An internal error occured" + e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

}
