package com.freshman.exception;

import com.freshman.controller.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LocalException extends RuntimeException{

    @ExceptionHandler
    public Result doException(Exception exception){
        exception.printStackTrace();
        return new Result(500,"服务器异常，请稍后再试");
    }
}
