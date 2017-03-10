package tr.com.iyzico.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.client.api.PaymentService;

/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class CardService {

    @Autowired
    private PaymentService paymentService;

    public boolean isSuitableForPayment(String binNumber){
        return true;
    }
}
