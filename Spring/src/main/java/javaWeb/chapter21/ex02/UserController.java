package javaWeb.chapter21.ex02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends MultiActionController {
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res){
        return new ModelAndView("login");
    }
}
