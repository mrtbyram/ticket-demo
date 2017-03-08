package tr.com.iyzico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.iyzico.repo.EventRepository;
import tr.com.iyzico.repo.TalkRepository;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
public class EventController {

    @Autowired
    EventRepository eventRepo;

    @Autowired
    TalkRepository talkRepo;

    @RequestMapping("/event/{ref}")
    public String eventDetail(@PathVariable String ref, Model model){
        Integer eventId = Integer.parseInt(ref);

        model.addAttribute("event", eventRepo.findOne(eventId));
        model.addAttribute("talks", talkRepo.findTalkByEventId(eventId));

        return "event-detail";
    }

}