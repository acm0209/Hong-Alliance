package Hongikstruggle.HongAlliance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/members/login")
    public String Home() {return "login";}

}
