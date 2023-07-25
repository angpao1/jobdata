package com.example.jobdata.controllers.advice;

import com.example.jobdata.common.BaseResponseExceptionHandler;
import com.example.jobdata.controllers.JobDataController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice(assignableTypes = {
        JobDataController.class,
})
public class ResponseExceptionHandler extends BaseResponseExceptionHandler {

}
