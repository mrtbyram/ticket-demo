package tr.com.iyzico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.iyzico.repo.EventRepository;
import tr.com.iyzico.repo.entity.Event;

import java.util.List;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController extends IyziController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/bincheck", method = RequestMethod.POST)
    public String events(@RequestParam String binNumber, Model model){
        return "register";
    }
}