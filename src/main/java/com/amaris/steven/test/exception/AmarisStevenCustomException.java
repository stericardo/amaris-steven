package com.amaris.steven.test.exception;

import com.amaris.steven.test.contants.AmarisStevenConstants;
import com.amaris.steven.test.response.HttpErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AmarisStevenCustomException extends ResponseEntityExceptionHandler
{
    Logger logger = LoggerFactory.getLogger(AmarisStevenCustomException.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<HttpErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        logger.debug("ERROR " + ex.getMessage());
        ex.printStackTrace();
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.SERVER_ERROR, details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public final ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.debug("ERROR " + ex.getMessage());
        ex.printStackTrace();
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.SERVER_API_ERROR, details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(fieldName + " : " + errorMessage);
        });
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.SERVER_API_ERROR, errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.PARAMETER_MISSING, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public final ResponseEntity<HttpErrorResponse> handleBrandNotFoundException(BrandNotFoundException ex,
                                                                           WebRequest request) {
        ex.printStackTrace();
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.BRAND_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<HttpErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
                                                                               WebRequest request) {
        ex.printStackTrace();
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        HttpErrorResponse error = new HttpErrorResponse(AmarisStevenConstants.PRODUCT_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
