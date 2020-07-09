package com.hmd007.monetbill.service;

import com.hmd007.monetbill.model.request.CheckPaymentRequest;
import com.hmd007.monetbill.model.request.PlacePaymentRequest;
import com.hmd007.monetbill.model.response.CheckPaymentResponse;
import com.hmd007.monetbill.model.response.PlacePaymentResponse;

public interface MonetbilInterface {
    PlacePaymentResponse placePayment(PlacePaymentRequest placePaymentRequest, String url);
    CheckPaymentResponse checkPayment(CheckPaymentRequest checkPaymentRequest, String url);
}
