package tr.com.iyzico.core.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.iyzico.core.model.Promotion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class PromotionFinderTest {

    Map<String, Promotion> testMap;

    @Before
    public void setUp(){
        testMap = new HashMap<>();
        testMap.put("GAMMA", new Promotion("GAMMA", Arrays.asList("1303"), 10));
        testMap.put("BECK", new Promotion("BECK", Arrays.asList("3103"), 10));
        testMap.put("CUNNINGHAM", new Promotion("CUNNINGHAM", Arrays.asList("2605"), 10));
        testMap.put("AGILE", new Promotion("AGILE", Arrays.asList("1102", "1202", "1302"), 10));
    }

    @Test
    public void should_find_ticket_by_code(){
        PromotionFinder finder = new PromotionFinder(testMap);

        assertNotNull(finder.findPromotionByCode("GAMMA"));
        assertNull(finder.findPromotionByCode("EMMA"));
    }

    @Test
    public void should_find_ticket_by_code_for_today(){
        testMap.put("TODAY_CAMP", getATodayPromotion());
        testMap.put("TOMORROW_CAMP", getATomorrowPromotion());
        PromotionFinder finder = new PromotionFinder(testMap);

        assertNotNull(finder.findPromotionByCodeForToday("TODAY_CAMP"));
        assertNull(finder.findPromotionByCodeForToday("TOMORROW_CAMP"));
        assertNull(finder.findPromotionByCodeForToday("NO_CAMP"));
    }

    private Promotion getATodayPromotion(){
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMM"));
        Promotion todayPromotion = new Promotion("TODAY_CAMP", Arrays.asList(today), 10);
        return todayPromotion;
    }

    private Promotion getATomorrowPromotion(){
        String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("ddMM"));
        Promotion tomorrowPromotion = new Promotion("TOMORROW_CAMP", Arrays.asList(tomorrow), 10);
        return tomorrowPromotion;
    }
}
