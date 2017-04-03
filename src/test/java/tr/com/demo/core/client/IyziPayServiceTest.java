package tr.com.demo.core.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.demo.TicketApplication;
import tr.com.demo.core.model.BinCard;
import tr.com.demo.core.client.api.PaymentService;

import static org.junit.Assert.*;
/**
 * Created by muratbayram on 10/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(TicketApplication.class)
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
