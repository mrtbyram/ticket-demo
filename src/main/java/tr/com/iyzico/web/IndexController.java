package tr.com.iyzico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.iyzico.repo.EventRepository;
import tr.com.iyzico.repo.entity.Event;

import java.util.List;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
public class IndexController extends IyziController {

    EventRepository eventRepo;

    @Autowired
    public IndexController(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/events")
    public String events(Model model){
        List<Event> events = eventRepo.findAll();

        model.addAttribute("events", events);

        return "events";
    }
}