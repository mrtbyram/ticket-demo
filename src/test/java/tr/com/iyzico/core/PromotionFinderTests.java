package tr.com.iyzico.core;

import org.junit.Test;
import tr.com.iyzico.core.model.Promotion;
import tr.com.iyzico.core.service.PromotionFinder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by muratbayram on 12/03/2017.
 */
public class PromotionFinderTests {

    @Test
    public void should_find_ticket_by_date(){
        Map<String, Promotion> testMap = new HashMap<>();
        testMap.put("GAMMA", new Promotion("GAMMA", Arrays.asList("1303"), 10));
        testMap.put("BECK", new Promotion("BECK", Arrays.asList("3103"), 10));
        testMap.put("CUNNINGHAM", new Promotion("CUNNINGHAM", Arrays.asList("2605"), 10));
        testMap.put("AGILE", new Promotion("AGILE", Arrays.asList("1102", "1202", "1302"), 10));
        PromotionFinder finder = new PromotionFinder(testMap);

        assertNotNull(finder.findPromotionByCode("GAMMA"));
        assertNull(finder.findPromotionByCode("EMMA"));
    }
}
