package com.ksa.ekycregister.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class AbstractDTO<E> {
    private static final long serialVersionUID = 1234567890L;
    private final String time;
    private int code = 0;
    private String message;
    private E data;
    @JsonProperty("trace_id")
    private String traceId;
    public AbstractDTO() {
        this.time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.message = "Successful!";
    }
}