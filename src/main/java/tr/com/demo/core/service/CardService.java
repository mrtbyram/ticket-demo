package tr.com.demo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.demo.core.client.api.PaymentService;
import tr.com.demo.core.exceptions.NoBankException;
import tr.com.demo.core.model.Bank;
import tr.com.demo.core.model.BinCard;
import tr.com.demo.core.model.CardType;

import java.util.logging.Logger;

/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class CardService {

    private Logger logger = Logger.getLogger(CardService.class.getName());

    private PaymentService paymentService;

    @Autowired
    public CardService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean checkForPayment(String binNumber){
        BinCard binCard = paymentService.retrieveCardProperties(binNumber);

        return isCardSuitableForPayment(binCard);
    }

    private boolean isCardSuitableForPayment(BinCard binCard){
        try{
            Bank bank = Bank.getBank(binCard.getBankCode());
            CardType cardType = CardType.getCardType(binCard.getCardType());

            return bank.isSuitableForCard(cardType);
        }catch (NoBankException nbex){
            logger.warning("Couldnt found a bank for " + binCard.getBankCode());
            return false;
        }
    }
}
