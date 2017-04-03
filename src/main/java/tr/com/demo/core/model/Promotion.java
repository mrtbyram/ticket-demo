package tr.com.demo.core.model;

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

    public String getCode() {
        return code;
    }

    public List<String> getDates() {
        return dates;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
