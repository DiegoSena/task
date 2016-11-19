package com.fexco.address.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import retrofit.RetrofitError;

import java.io.IOException;

/**
 * Created by diego.guimaraes on 18/11/16.
 */
@ControllerAdvice
public class ExceptionHandler {

    private static final Log LOG = LogFactory.getLog(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler
    public Object handleErrorAccessingExternalService(RetrofitError e){
        LOG.error("User not allowed " + e);
        return new ResponseEntity(new BasicError(HttpStatus.FORBIDDEN.toString(),
                                  HttpStatus.FORBIDDEN.getReasonPhrase()), HttpStatus.FORBIDDEN);
    }

    public class BasicError{
        private String status;
        private String message;

        public BasicError(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public String getStatus() {
            return status;
        }
    }
}
