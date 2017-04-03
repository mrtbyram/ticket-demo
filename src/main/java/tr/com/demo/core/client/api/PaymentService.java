package tr.com.demo.core.client.api;

import tr.com.demo.core.model.BinCard;

/**
 * Created by muratbayram on 10/03/2017.
 */
public interface PaymentService {

    BinCard retrieveCardProperties(String binNumber);

}
