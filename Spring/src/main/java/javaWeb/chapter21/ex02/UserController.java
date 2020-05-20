package javaWeb.chapter21.ex02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


public class UserController extends MultiActionController {
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
        String id = "";
        String pw = "";
        ModelAndView mv = new ModelAndView();
        req.setCharacterEncoding("utf-8");
        id = req.getParameter("id");
        pw = req.getParameter("pw");

        req.setAttribute("id_pw", id + pw);

        // modelAndView에 로그인 정보를 담음
        mv.addObject("id", id);
        mv.addObject("pw", pw);

        mv.setViewName("result");
        return mv;
    }
}
