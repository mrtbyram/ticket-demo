package tr.com.iyzico.core.model;

/**
 * Created by muratbayram on 10/03/2017.
 */
public enum Bank {
    GARANTI(Long.valueOf(62), CardType.CREDIT_CARD),
    ISBANK(Long.valueOf(64), CardType.CREDIT_CARD),
    AKBANK(Long.valueOf(46), CardType.CREDIT_CARD),
    FINANS(Long.valueOf(111), CardType.CREDIT_CARD),
    HALK(Long.valueOf(12), CardType.DEBIT_CARD);

    private final Long bankCode;
    private final CardType cardType;

    Bank(Long code, CardType cardType) {
        this.bankCode = code;
        this.cardType = cardType;
    }

    public boolean isSuitableForCard(CardType type){
        return this.cardType.equals(type);
    }

    public static Bank getBank(Long bankCode){
        for (Bank bank : Bank.values()){
            if(bank.bankCode.equals(bankCode)) return bank;
        }
        return null;
    }
}