package tr.com.iyzico.core.model;

/**
 * Created by muratbayram on 10/03/2017.
 */
public enum CardType {
    DEBIT_CARD("DEBIT_CARD"),
    CREDIT_CARD("CREDIT_CARD");

    private final String typeName;

    CardType(String typeName) {
        this.typeName = typeName;
    }

    public static CardType getCardType(String typeName) {
        for (CardType type : CardType.values()){
            if(type.typeName.equals(typeName)) return type;
        }
        return null;
    }
}
