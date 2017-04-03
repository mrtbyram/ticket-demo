package tr.com.iyzico.core.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.iyzico.IyzicoticketApplication;
import tr.com.iyzico.core.model.BinCard;
import tr.com.iyzico.core.client.api.PaymentService;

import static org.junit.Assert.*;
/**
 * Created by muratbayram on 10/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(IyzicoticketApplication.class)
@ActiveProfiles("test")
public class IyziPayServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void should_retrieve_bin_number(){
        BinCard binCard = paymentService.retrieveCardProperties("589004");

        assertEquals(new Long(46), binCard.getBankCode());
        assertEquals("DEBIT_CARD", binCard.getCardType());
    }
}
