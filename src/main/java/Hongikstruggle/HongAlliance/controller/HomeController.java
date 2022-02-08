package Hongikstruggle.HongAlliance.controller;


import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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



}
