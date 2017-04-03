package tr.com.demo.core.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by muratbayram on 11/03/2017.
 */
public class BankTest {

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
