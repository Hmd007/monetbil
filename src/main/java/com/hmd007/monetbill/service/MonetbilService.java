package com.hmd007.monetbill.service;

import com.hmd007.monetbill.model.request.CheckPaymentRequest;
import com.hmd007.monetbill.model.request.PlacePaymentRequest;
import com.hmd007.monetbill.model.response.CheckPaymentResponse;
import com.hmd007.monetbill.model.response.PlacePaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class MonetbilService implements MonetbilInterface {
    static final Logger LOGGER = LoggerFactory.getLogger(MonetbilService.class);
    @Override
    public PlacePaymentResponse placePayment(PlacePaymentRequest placePaymentRequest, String url) {
        LOGGER.info("send request on url={} with params {}", url, placePaymentRequest);
        PlacePaymentResponse placePaymentResponse = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PlacePaymentRequest> httpEntity = new HttpEntity<>(placePaymentRequest);
        ResponseEntity<PlacePaymentResponse> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, PlacePaymentResponse.class);
            LOGGER.info("Traitement de requête avec succès");
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            LOGGER.error("Code erreur: {} - Message: {}", e.getStatusCode().value(), e.getMessage());
        } catch (RestClientException e) {
            LOGGER.error("{}", e.getMessage());
        }
        if (responseEntity == null || responseEntity.getBody() == null) return null;
        return responseEntity.getBody();
    }

    @Override
    public CheckPaymentResponse checkPayment(CheckPaymentRequest checkPaymentRequest, String url) {
        LOGGER.info("check payment on url={} with params {}", url, checkPaymentRequest);
        ResponseEntity<CheckPaymentResponse> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("paymentId", checkPaymentRequest.getPaymentId());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(valueMap, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, CheckPaymentResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            LOGGER.error("Message: {}", e.getMessage());
        } catch (RestClientException e) {
            LOGGER.error("{}", e.getMessage());
        }
        if (responseEntity == null || responseEntity.getBody() == null) return null;
        return responseEntity.getBody();
    }
}
