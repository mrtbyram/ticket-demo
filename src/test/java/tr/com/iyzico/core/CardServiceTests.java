package tr.com.iyzico.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.iyzico.IyzicoticketApplication;
import tr.com.iyzico.core.service.CardService;

import static org.junit.Assert.*;

/**
 * Created by muratbayram on 11/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(IyzicoticketApplication.class)
@ActiveProfiles("test")
public class CardServiceTests {

    @Autowired
    private CardService cardService;

    @Test
    public void should_determine_card_is_suitable(){
        assertFalse(cardService.checkForPayment("5890004")); //AKBANK DEBIT
        assertFalse(cardService.checkForPayment("123456")); //INCORRECT CARD
        assertFalse(cardService.checkForPayment("552879")); //HALK CREDIT
        assertFalse(cardService.checkForPayment("550472")); //HSBC CREDIT
        assertFalse(cardService.checkForPayment("")); //EMPTY BIN
        assertFalse(cardService.checkForPayment(null)); //NULL BIN

        assertTrue(cardService.checkForPayment("552608")); //AKBANK CREDIT
        assertTrue(cardService.checkForPayment("447505")); //HALK DEBIT
    }
}
