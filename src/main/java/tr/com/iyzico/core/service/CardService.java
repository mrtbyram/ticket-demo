package tr.com.iyzico.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.client.api.PaymentService;
import tr.com.iyzico.core.model.Bank;
import tr.com.iyzico.core.model.Card;
import tr.com.iyzico.core.model.CardType;

/**
 * Created by muratbayram on 10/03/2017.
 */
@Service
public class CardService {

    @Autowired
    private PaymentService paymentService;

    public boolean isSuitableForPayment(String binNumber){
        Card card = paymentService.retrieveCardProperties(binNumber);

        Bank bank = Bank.getBank(card.getBankCode());
        CardType cardType = CardType.getCardType(card.getCardType());

        if(bank != null){
            return bank.isSuitableForCard(cardType);
        }else{
            return false;
        }
    }
}
