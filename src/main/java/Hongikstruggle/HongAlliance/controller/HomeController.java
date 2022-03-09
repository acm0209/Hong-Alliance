package Hongikstruggle.HongAlliance.controller;


import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.domain.User;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

@Controller
public class HomeController {

    @Autowired
    private HttpSession session;


    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/admin")
    public String Admin() {return "admin";}

    @GetMapping("/naver_map")
    public String Naver_map(HttpServletRequest request, Model model){

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        System.out.println(session.isNew());

        String attr = (String) session.getAttribute("ssVar");
        System.out.println(attr);

        String tmp = attr + "1";
        session.setAttribute("ssVar",tmp);


        String CLIENTID = Store.getCLIENTID();
        model.addAttribute("CLIENTID",CLIENTID);

        return "naver_map";
    }

    @GetMapping("/newone")
    public String newone(){
        return "newone";
    }


    @GetMapping("/test")
    public String test(HttpServletRequest request){

        HttpSession session = request.getSession();

        System.out.println(session.isNew());
        System.out.println(session.getMaxInactiveInterval() - session.getCreationTime());

        String name = "세션저장하기";
        session.setAttribute("ssVar",name);


        String attr = (String) session.getAttribute("ssVar");
        System.out.println(attr);

        return "test";
    }

}
