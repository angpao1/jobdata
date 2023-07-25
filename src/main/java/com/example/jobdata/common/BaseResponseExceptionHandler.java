package com.example.jobdata.common;

import com.example.jobdata.common.exception.InvalidInputException;
import com.example.jobdata.constants.ResConstant;
import com.example.jobdata.models.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class BaseResponseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<?> handleException(Exception ex) {
        log.debug("Controller Handle Exception", ex);
        return ResponseBuilder.errorInternalServer();
    }

    @ExceptionHandler({InvalidInputException.class})
    protected ResponseEntity<?> handleInvalidInputException(final Exception ex) {
        log.debug("Controller Handle InvalidInputException", ex);
        String msg = ex.getMessage();
        return ResponseBuilder.errorInvalidParams(ResConstant.ERR_INVALID_PARAMS.getDescription().replace("$field_name", msg != null ? msg : ""));
    }
}
