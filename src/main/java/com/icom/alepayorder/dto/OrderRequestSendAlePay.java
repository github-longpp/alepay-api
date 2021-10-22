package com.icom.alepayorder.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderRequestSendAlePay {
    private String amount;
    private BigInteger userId;
    private String customMerchantId;
    private String orderCode;
    private String orderDescription;
    private String tokenKey;
}
