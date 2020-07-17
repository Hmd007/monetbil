package com.hmd007.monetbill.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class CheckPaymentResponse {
    private String paymentId;
    private String message;
    private Transaction transaction;
}
