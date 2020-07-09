package com.hmd007.monetbill;

import com.hmd007.monetbill.model.request.PlacePaymentRequest;
import com.hmd007.monetbill.model.response.PlacePaymentResponse;
import com.hmd007.monetbill.service.MonetbilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonetbillApplication implements CommandLineRunner {
    static final Logger LOGGER = LoggerFactory.getLogger(MonetbillApplication.class);
    private MonetbilService monetbilService;
    @Value("${api.base-url}")
    private String apiBaseUrl;
    @Value("${api.service}")
    private String apiService;


    public MonetbillApplication(MonetbilService monetbilService) {
        this.monetbilService = monetbilService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MonetbillApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = apiBaseUrl + "/payment/v1/placePayment";
        LOGGER.info("url ");
        PlacePaymentResponse placePaymentResponse = null;
        PlacePaymentRequest placePaymentRequest = new PlacePaymentRequest();
        placePaymentRequest.setService(apiService);
        placePaymentRequest.setPhonenumber("237697807674");
        placePaymentRequest.setAmount("150");
        placePaymentRequest.setOperator("CM_ORANGEMONEY");
        placePaymentRequest.setEmail("wanashamad123@gmail.com");

        placePaymentResponse = monetbilService.placePayment(placePaymentRequest, url);
        LOGGER.info("{}", placePaymentResponse);
    }
}
