package tr.com.iyzico.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
public class EventController {

    @RequestMapping("/event/{ref}")
    public String eventDetail(@PathVariable String ref, Model model){
        return "event-detail";
    }

}