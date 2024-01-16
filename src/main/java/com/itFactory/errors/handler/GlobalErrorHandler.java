package com.itFactory.errors.handler;

import com.itFactory.errors.ErrorResponse;
import com.itFactory.errors.UserWasNotDeletedException;
import com.itFactory.errors.UserWasNotUpdatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(UserWasNotDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserWasNotDeleted(UserWasNotDeletedException ex){
        logger.error("Error: ", ex); // foarte important de folosit ca sa vedeti exceptiile


        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(UserWasNotUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserWasNotUpdated(UserWasNotUpdatedException ex){
        logger.error("Error: ", ex); // foarte important de folosit ca sa vedeti exceptiile

        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex){
        logger.error("Error: ", ex); // foarte important de folosit ca sa vedeti exceptiile
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }



}
