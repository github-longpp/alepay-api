package com.icom.alepayorder.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderRequest {
    private BigInteger userId;
    private String amount;
    private String bankCode;
    private String cancelUrl;
    private String returnUrl;

}
