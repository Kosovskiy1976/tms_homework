package classes.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(ViewedException.class)
    public ModelAndView errorHandler(Exception ex) {
        ModelAndView mav = new ModelAndView("errorpage");
        mav.addObject("error", ex.getMessage());
        return mav;
    }
}
