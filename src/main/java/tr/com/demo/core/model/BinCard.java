package tr.com.demo.core.model;

/**
 *
 *
 * @author muratbayram
 */
public class BinCard {

    private Long bankCode;
    private String cardType;


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public Long getBankCode() {
        return bankCode;
    }
}
