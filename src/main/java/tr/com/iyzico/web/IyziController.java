package tr.com.iyzico.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by muratbayram on 09/03/2017.
 */
public abstract class IyziController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @ExceptionHandler(Exception.class)
    public ModelAndView errorPage(HttpServletRequest req, Exception ex) {
        logger.log(Level.SEVERE, "Request: " + req.getRequestURL() + " raised " + ex, ex);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
