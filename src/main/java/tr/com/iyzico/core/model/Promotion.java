package tr.com.iyzico.core.model;

import java.util.List;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class Promotion {

    private String code;
    private List<String> dates; //ddMM
    private int discountPercentage;

    public Promotion(String code, List<String> date, int discountPercentage) {
        this.code = code;
        this.dates = date;
        this.discountPercentage = discountPercentage;
    }

}
