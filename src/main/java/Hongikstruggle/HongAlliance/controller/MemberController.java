package Hongikstruggle.HongAlliance.controller;

import Hongikstruggle.HongAlliance.repository.KakaoOauth;
import Hongikstruggle.HongAlliance.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Controller
public class MemberController {


    @GetMapping ("/members/kakao_login")
    public String kakologin(String code) {


        //System.out.println(code);

        return "home";
    }


    @GetMapping("/test")
    public String test(@RequestParam String code){

        System.out.println(code);
        MemberService memberService = new MemberService();
        String token = memberService.getKakaoAccessToken(code);
        System.out.println(token);

        return "redirect:/";
    }




}