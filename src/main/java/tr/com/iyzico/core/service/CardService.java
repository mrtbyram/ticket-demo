package tr.com.iyzico.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.client.api.PaymentService;
import tr.com.iyzico.core.exceptions.NoBankException;
import tr.com.iyzico.core.model.Bank;
import tr.com.iyzico.core.model.BinCard;
import tr.com.iyzico.core.model.CardType;

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
