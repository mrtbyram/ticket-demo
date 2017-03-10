package tr.com.iyzico.core.client.impl;

import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.ApplicationParams;
import tr.com.iyzico.core.model.Card;
import tr.com.iyzico.core.client.api.PaymentService;

/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class IyzipayServiceImpl implements PaymentService {

    @Autowired
    private ApplicationParams params;

    @Override
    public Card retrieveCardProperties(String binNumber) {
        Card card = new Card();

        RetrieveBinNumberRequest serviceRequest = new RetrieveBinNumberRequest();
        serviceRequest.setConversationId("123");
        serviceRequest.setLocale(Locale.TR.getValue());
        serviceRequest.setBinNumber(binNumber);

        BinNumber serviceResponse = BinNumber.retrieve(serviceRequest, params.getApiOptions());

        card.setBankCode(serviceResponse.getBankCode());
        card.setCardType(serviceResponse.getCardType());

        return card;
    }
}
