package com.icom.alepayorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class PaymentRequest {
    private String transactionCode;
    private String orderCode;
    private Double customerFeeAmount;
    private Double merchantFee;
    private String currency;
    private BigInteger userId;
    private String status;
    private String message;
    private String reason;
    private boolean installment;
    private boolean is3D;
    private Double month;
    private String bankCode;
    private String bankName;
    private String method;
    private Long transactionTime;
    private Long successTime;
    private String bankHotline;
    private String checksum;
}
