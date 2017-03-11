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
        assertFalse(cardService.isSuitableForPayment("5890004")); //AKBANK DEBIT
        assertFalse(cardService.isSuitableForPayment("123456")); //INCORRECT CARD
        assertFalse(cardService.isSuitableForPayment("552879")); //HALK CREDIT
        assertFalse(cardService.isSuitableForPayment("550472")); //HSBC CREDIT
        assertFalse(cardService.isSuitableForPayment("")); //EMPTY BIN
        assertFalse(cardService.isSuitableForPayment(null)); //NULL BIN

        assertTrue(cardService.isSuitableForPayment("552608")); //AKBANK CREDIT
        assertTrue(cardService.isSuitableForPayment("447505")); //HALK DEBIT
    }
}
