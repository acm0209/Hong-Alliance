package Hongikstruggle.HongAlliance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {


    //show list 로 통일하고, 인자만 바꿔주는 형식으로 해서 홈페이지를 구성해 보자.

    @GetMapping("/members")
    public String members(){return "members";}


}
