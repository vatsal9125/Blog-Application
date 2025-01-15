package com.vatsal.blog.exceptions;

import com.vatsal.blog.payload.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(message,false);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fieldError -> fieldError.getField(),
                        fieldError -> fieldError.getDefaultMessage(),
                        (existingValue, newValue) -> existingValue // Handle duplicate keys
                ));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Reason for not using this method is because It just throws error with the above method
    // i am key-value(feildName-Error)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, String> resp = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            resp.put(fieldName, message);
//        });
//
//        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
//    }

}
