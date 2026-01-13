package com.bzdata.TataFneBackend.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse {
    protected String timeStamp;
    protected String reason;
    protected int statusCode;
    protected String message;
    protected String messageDeveloper;
    protected HttpStatus httpStatus;
    protected Map<?, ?> data;
}
