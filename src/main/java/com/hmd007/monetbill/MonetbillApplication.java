package com.hmd007.monetbill;

import com.hmd007.monetbill.model.request.PlacePaymentRequest;
import com.hmd007.monetbill.model.response.PlacePaymentResponse;
import com.hmd007.monetbill.service.MonetbilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonetbillApplication implements CommandLineRunner {
    static final Logger LOGGER = LoggerFactory.getLogger(MonetbillApplication.class);
    private MonetbilService monetbilService;

    public MonetbillApplication(MonetbilService monetbilService) {
        this.monetbilService = monetbilService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MonetbillApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "https://api.monetbil.com/payment/v1/placePayment ";
        PlacePaymentResponse placePaymentResponse = null;
        PlacePaymentRequest placePaymentRequest = new PlacePaymentRequest();
        placePaymentResponse = monetbilService.placePayment(placePaymentRequest, url);
        LOGGER.info("{}", placePaymentResponse);
    }
}
