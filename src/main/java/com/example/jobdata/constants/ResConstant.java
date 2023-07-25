package com.example.jobdata.constants;

import com.example.jobdata.models.response.Res;

public class ResConstant {

    public static final Res ERR_INVALID_PARAMS = Res.builder().description("Invalid parameter: $field_name").build();
    public static final Res ERR_INTERNAL_SERVER = Res.builder().description("Internal server error").build();
}
