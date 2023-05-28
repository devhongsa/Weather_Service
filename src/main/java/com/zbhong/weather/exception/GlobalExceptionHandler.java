package com.zbhong.weather.exception;

import com.zbhong.weather.WeatherApplication;
import com.zbhong.weather.dto.ErrorResponse;
import com.zbhong.weather.type.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.zbhong.weather.type.ErrorCode.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);

    @ExceptionHandler(DiaryException.class)
    public ErrorResponse handleAccountException(DiaryException e) {
        logger.error("{} is occurred.",e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMassage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class) //Controller에서 어떤 에러든 발생하면 이 함수가 실행됨. Custom Error제외
    public ErrorResponse handleAllException(Exception e){
        logger.error("Exception is occurred", e);
        return new ErrorResponse(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.getDescription());
    }
}
