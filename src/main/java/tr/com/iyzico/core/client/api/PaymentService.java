package tr.com.iyzico.core.client.api;

import tr.com.iyzico.core.model.BinCard;

/**
 * Created by muratbayram on 10/03/2017.
 */
public interface PaymentService {

    BinCard retrieveCardProperties(String binNumber);

}
