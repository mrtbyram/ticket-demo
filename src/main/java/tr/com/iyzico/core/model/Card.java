package tr.com.iyzico.core.model;

/**
 * Created by muratbayram on 10/03/2017.
 */
public class Card {

    private Long bankCode;
    private CardType cardType;


    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = CardType.getCardType(cardType);
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public Long getBankCode() {
        return bankCode;
    }
}
