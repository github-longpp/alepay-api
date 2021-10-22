package com.icom.alepayorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private String code;
    private String message;
    private String checkoutUrl;
    private String transactionCode;
}
