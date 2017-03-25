package tr.com.iyzico.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by muratbayram on 09/03/2017.
 */
public abstract class IyziController {

    private final Logger logger = LoggerFactory.getLogger(IyziController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView errorPage(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex, ex);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
