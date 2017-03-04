package tr.com.iyzico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by muratbayram on 04/03/2017.
 */
@RestController
@RequestMapping("/test")
public class RestTest {

    @Autowired
    private UserRepo repo;

    @RequestMapping("/")
    public void test(){
        User n = new User();
        n.setName("asd");
        n.setEmail("mail");
        repo.save(n);

    }

}
