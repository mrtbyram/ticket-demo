package tr.com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.demo.repo.EventRepository;
import tr.com.demo.repo.TalkRepository;
import tr.com.demo.repo.entity.Event;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
public class EventController {

    private EventRepository eventRepo;

    private TalkRepository talkRepo;

    @Autowired
    public EventController(EventRepository eventRepo, TalkRepository talkRepo) {
        this.eventRepo = eventRepo;
        this.talkRepo = talkRepo;
    }

    @RequestMapping("/event/{ref}")
    public String eventDetail(@PathVariable String ref, Model model){
        if(!isNumeric(ref)) return "no-event";

        Integer eventId = Integer.parseInt(ref);
        Event event = eventRepo.findOne(eventId);

        if(event != null){
            model.addAttribute("event", event);
            model.addAttribute("talks", talkRepo.findTalkByEventId(event.getId()));

            return "event-detail";
        }else{
            return "no-event";
        }
    }

    private boolean isNumeric(String value){
        return value.matches("[0-9]+");
    }
}