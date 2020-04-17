package javaWeb.chapter21.ex01;


import com.sun.javafx.util.Logging;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

public class SimpleUrlController implements Controller {

    @Override
    public ModelAndView handleRequest (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println("/test/index.do");
        return new ModelAndView("index.jsp");
    }
}
