package tr.com.iyzico.core.model;

import static org.junit.Assert.*;
import org.junit.Test;
import tr.com.iyzico.core.model.Bank;
import tr.com.iyzico.core.model.CardType;

/**
 * Created by muratbayram on 11/03/2017.
 */
public class BankTests {

    @Test
    public void should_determine_card_type_is_suitable(){
        Bank bank = Bank.AKBANK;

        assertTrue(bank.isSuitableForCard(CardType.CREDIT_CARD));
        assertFalse(bank.isSuitableForCard(CardType.DEBIT_CARD));
        assertFalse(bank.isSuitableForCard(null));

        bank = Bank.HALK;

        assertFalse(bank.isSuitableForCard(CardType.CREDIT_CARD));
        assertTrue(bank.isSuitableForCard(CardType.DEBIT_CARD));
        assertFalse(bank.isSuitableForCard(null));
    }

}
