package com.example.investmentapp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String>handlerNoHandlerFoundException(NoHandlerFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запрошенный ресурс не найден. Перейдите на <a href='/api/test'>тестовую страницу</a>.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Произошла внутренняя ошибка сервера.");
    }
}
