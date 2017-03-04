package tr.com.iyzico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by muratbayram on 04/03/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name", "ThymeLeaf");
        return "index";
    }
}
