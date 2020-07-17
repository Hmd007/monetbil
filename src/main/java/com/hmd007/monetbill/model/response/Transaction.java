package com.hmd007.monetbill.model.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class Transaction {
    private int status;
    private String message;
    private String amount;
    @JsonAlias("transaction_UUID")
    private String transactionUuid;
    private String msisdn;
    private String fee;
    private String revenue;
}
