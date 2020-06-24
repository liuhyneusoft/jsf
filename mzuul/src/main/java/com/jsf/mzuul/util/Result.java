package com.jsf.mzuul.util;
import java.util.Map;

import lombok.Data;

@Data
public class Result<T> {
    private String code = "0";
    private String msg = "ok";
    private T data;
    private Map<String, String> responseBody;
}