package Hongikstruggle.HongAlliance.controller;

import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.domain.StoreForm;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import com.mysql.cj.protocol.Resultset;
import org.apache.catalina.session.StandardSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static Hongikstruggle.HongAlliance.repository.JdbcConnection.getConnection;

@Controller
@SessionAttributes("users")
public class AddformController {

    @GetMapping("/addform")
    public String addform(HttpServletRequest request){
        HttpSession session = request.getSession();

        if(session.isNew()) {
            Integer cnt = 3;
            session.setAttribute("ssVar", cnt); //최대 3번 입력 가능.
        }

        return "addform";
    }

    @PostMapping("/addform")
    public String postform(HttpServletRequest request,StoreForm form){

        HttpSession session = request.getSession();

        Integer cnt = (Integer) session.getAttribute("ssVar")-1;
        session.setAttribute("ssVar",cnt);

        JdbcConnection.PostNewStore(form);

        return "addform";
    }


}
