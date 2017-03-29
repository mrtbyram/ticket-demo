package tr.com.iyzico.core.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tr.com.iyzico.core.model.Promotion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by muratbayram on 12/03/2017.
 */
@Service
@Scope("singleton")
public class PromotionFinder {
    private Map<String, Promotion> promotionMap;

    public PromotionFinder() {
        promotionMap = new HashMap<>();
        promotionMap.put("GAMMA", new Promotion("GAMMA", Arrays.asList("1303"), 10));
        promotionMap.put("BECK", new Promotion("BECK", Arrays.asList("3103"), 10));
        promotionMap.put("CUNNINGHAM", new Promotion("CUNNINGHAM", Arrays.asList("2605"), 10));
        promotionMap.put("AGILE", new Promotion("AGILE", Arrays.asList("1102", "1202", "1302"), 10));
    }

    public PromotionFinder(Map<String, Promotion> promotionMap) {
        this.promotionMap = promotionMap;
    }

    public Promotion findPromotionByCode(String code){
        return promotionMap.get(code);
    }

    public Promotion findPromotionByCodeForToday(String code) {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMM"));

        Promotion p = findPromotionByCode(code);
        if(p != null && p.getDates().contains(today)){
            return p;
        }
        return null;
    }
}
