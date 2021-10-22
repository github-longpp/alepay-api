package com.icom.alepayorder.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderRequest {
    private String amount;
    private BigInteger userId;

}
