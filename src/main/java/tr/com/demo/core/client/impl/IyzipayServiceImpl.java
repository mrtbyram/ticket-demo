package tr.com.demo.core.client.impl;

import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.demo.core.ApplicationParams;
import tr.com.demo.core.model.BinCard;
import tr.com.demo.core.client.api.PaymentService;

/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class IyzipayServiceImpl implements PaymentService {

    private ApplicationParams params;

    @Autowired
    public IyzipayServiceImpl(ApplicationParams params) {
        this.params = params;
    }

    @Override
    public BinCard retrieveCardProperties(String binNumber) {
        BinCard binCard = new BinCard();

        RetrieveBinNumberRequest serviceRequest = new RetrieveBinNumberRequest();
        serviceRequest.setConversationId("123");
        serviceRequest.setLocale(Locale.TR.getValue());
        serviceRequest.setBinNumber(binNumber);

        BinNumber serviceResponse = BinNumber.retrieve(serviceRequest, params.getApiOptions());

        binCard.setBankCode(serviceResponse.getBankCode());
        binCard.setCardType(serviceResponse.getCardType());

        return binCard;
    }
}
