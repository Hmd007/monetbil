package com.hmd007.monetbill;

import com.hmd007.monetbill.model.request.CheckPaymentRequest;
import com.hmd007.monetbill.model.response.CheckPaymentResponse;
import com.hmd007.monetbill.model.response.PlacePaymentResponse;
import com.hmd007.monetbill.service.MonetbilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

/*
        String url = apiBaseUrl + "/payment/v1/placePayment";
        PlacePaymentResponse placePaymentResponse = null;
        PlacePaymentRequest placePaymentRequest = new PlacePaymentRequest();
        placePaymentRequest.setService(apiService);
        placePaymentRequest.setPhonenumber("237697807674");
        placePaymentRequest.setAmount("100");
        placePaymentRequest.setOperator("CM_EUMM");
        // placePaymentRequest.setEmail("wanashamad123@gmail.com");
        // placePaymentRequest.setCountry("CM");

        placePaymentResponse = monetbilService.placePayment(placePaymentRequest, url);
        LOGGER.info("{}", placePaymentResponse);

        // 20071008000626899356 - 20071000391378332552
        String idPayment = "20071000391378332552";
        checkPayment(idPayment);
*/
    }

    public void checkPayment(String idPayment) {
        String url = apiBaseUrl + "/payment/v1/checkPayment";
        CheckPaymentRequest checkPaymentRequest = new CheckPaymentRequest(idPayment, apiService);
        CheckPaymentResponse checkPaymentResponse = monetbilService.checkPayment(checkPaymentRequest, url);
        LOGGER.info("{}", checkPaymentResponse);
    }
}
