package com.icom.alepayorder.dto;

import lombok.Data;

@Data
public class ResponseListPackage {
    private String error_code;
    private String error_decs;
    private String data;
}
