package tr.com.iyzico.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.client.api.PaymentService;
import tr.com.iyzico.core.exceptions.NoBankException;
import tr.com.iyzico.core.model.Bank;
import tr.com.iyzico.core.model.Card;
import tr.com.iyzico.core.model.CardType;


/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class CardService {

    private Logger logger = LoggerFactory.getLogger(CardService.class);

    private PaymentService paymentService;

    @Autowired
    public CardService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean checkForPayment(String binNumber){
        Card card = paymentService.retrieveCardProperties(binNumber);

        return isCardSuitableForPayment(card);
    }

    private boolean isCardSuitableForPayment(Card card){
        try{
            Bank bank = Bank.getBank(card.getBankCode());
            CardType cardType = CardType.getCardType(card.getCardType());

            return bank.isSuitableForCard(cardType);
        }catch (NoBankException nbex){
            logger.warn("Couldnt found a bank for " + card.getBankCode());
            return false;
        }
    }
}
