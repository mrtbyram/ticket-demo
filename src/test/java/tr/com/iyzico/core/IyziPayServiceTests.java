package tr.com.iyzico.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.iyzico.IyzicoticketApplication;
import tr.com.iyzico.core.model.Card;
import tr.com.iyzico.core.client.api.PaymentService;

import static org.junit.Assert.*;
/**
 * Created by muratbayram on 10/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(IyzicoticketApplication.class)
@ActiveProfiles("test")
public class IyziPayServiceTests {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void should_retrieve_bin_number(){
        Card card = paymentService.retrieveCardProperties("589004");

        assertEquals(46L, card.getBankCode());
        assertEquals("DEBIT_CARD", card.getCardType());
    }
}
