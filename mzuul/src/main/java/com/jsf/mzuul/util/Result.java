package com.jsf.mzuul.util;
import java.util.Map;

import lombok.Data;

@Data
public class Result<T> {
    private int code = 0;
    private String message = "ok";
    private T data;
    private Map<String, String> responseBody;
}