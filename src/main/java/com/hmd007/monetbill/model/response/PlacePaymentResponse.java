package com.hmd007.monetbill.model.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class PlacePaymentResponse {
    private String status;
    private String message;
    @JsonAlias("channel_ussd")
    private String channelUssd;
    @JsonAlias("channel_name")
    private String channelName;
    @JsonAlias("channel")
    private String channel;
    @JsonAlias("payment_url")
    private String paymentUrl;
    private String paymentId;
}
