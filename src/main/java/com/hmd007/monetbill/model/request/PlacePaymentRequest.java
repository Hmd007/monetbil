package com.hmd007.monetbill.model.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class PlacePaymentRequest {
    private String service;
    private String phonenumber;
    private String amount;
    @JsonAlias("notify_url")
    private String notifyUrl;
    private String operator;
    private String currency;
    @JsonAlias("item_ref")
    private String itemRef;
    @JsonAlias("payment_ref")
    private String paymentRef;
    private String country;
    private String email;
}
