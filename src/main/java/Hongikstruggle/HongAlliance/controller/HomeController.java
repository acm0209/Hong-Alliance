package Hongikstruggle.HongAlliance.controller;


import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/admin")
    public String Admin() {return "admin";}

    @GetMapping("/naver_map")
    public String Naver_map(Model model){

        String CLIENTID = Store.getCLIENTID();

        model.addAttribute("CLIENTID",CLIENTID);

        return "naver_map";
    }

    @GetMapping("/newone")
    public String newone(){
        return "newone";
    }

}
