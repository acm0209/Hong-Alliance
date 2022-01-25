package Hongikstruggle.HongAlliance.controller;

import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static Hongikstruggle.HongAlliance.repository.JdbcConnection.getConnection;

@Controller
public class StoreController {


    //show list 로 통일하고, 인자만 바꿔주는 형식으로 해서 홈페이지를 구성해 보자.

    @GetMapping("/stores")
    public String stores(Model model){

        List<Store> lists = JdbcConnection.findAll();

        model.addAttribute("lists", lists);


        return "stores";
    }

    @GetMapping("/stores/cafe")
    public String storesCafe(Model model){

        List<Store> lists = JdbcConnection.findByEvent("cafe");

        model.addAttribute("lists", lists);


        return "stores";
    }




}
