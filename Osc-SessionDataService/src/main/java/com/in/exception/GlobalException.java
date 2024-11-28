package com.in.exception;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> recordNotFoundException(RecordNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> nullpointerException(NullPointerException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> emptyDataException(EmptyResultException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> methodArgumentException(MethodArgumentNotValidException ex){
        Map<String, String> resp=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldString=((FieldError)error).getField();
            String massage=	error.getDefaultMessage();
            resp.put(fieldString,massage);
        });
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> messageNotReadableException(HttpMessageNotReadableException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class, NoResourceFoundException.class})
    public ResponseEntity<String> handleBadRequestExceptions(Exception ex) {
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return new ResponseEntity<>("Enter the correct URL!!!", HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NoResourceFoundException) {
            return new ResponseEntity<>("Resource not found!!!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred!");
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<String> unexpectedTypeException(UnexpectedTypeException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        return new ResponseEntity<>("Enter the correct URL",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseEntity<String> unsupportedOperationException(UnsupportedOperationException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
