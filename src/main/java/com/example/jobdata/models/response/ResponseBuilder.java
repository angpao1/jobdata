package com.example.jobdata.models.response;

import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.SerializationUtils;


import static com.example.jobdata.constants.ResConstant.*;

public class ResponseBuilder {

    public static ResponseEntity<Object> success(Object resData) {
        return ResponseEntity.ok(resData);
    }

    private static Res getResponseWithDescription(Res res, String resDescription) {

        Res resClone = SerializationUtils.clone(res);
        if (resDescription != null) {
            resClone.setDescription(resDescription);
        }

        return resClone;
    }

    public static ResponseEntity<Object> errorInternalServer() {
        return ResponseEntity.internalServerError().body(ERR_INTERNAL_SERVER);
    }

    public static ResponseEntity<Object> errorInvalidParams(String description) {
        return ResponseEntity.badRequest().body(getResponseWithDescription(ERR_INVALID_PARAMS, description));
    }
}
