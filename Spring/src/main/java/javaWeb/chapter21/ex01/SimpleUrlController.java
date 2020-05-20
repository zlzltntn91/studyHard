package javaWeb.chapter21.ex01;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleUrlController implements Controller {

    @Override
    public ModelAndView handleRequest (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println("/test/index.do");
        return new ModelAndView("index.jsp");
    }
}
