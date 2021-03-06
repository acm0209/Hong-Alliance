package Hongikstruggle.HongAlliance.controller;

import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

import static Hongikstruggle.HongAlliance.repository.JdbcConnection.getConnection;

@Controller
public class StoreController {

    //show list 로 통일하고, 인자만 바꿔주는 형식으로 해서 홈페이지를 구성해 보자.

    @GetMapping("/stores")
    public String stores(Model model){

        JdbcConnection.getConnection();

        List<Store> lists = JdbcConnection.findAll();

        model.addAttribute("lists", lists);

        return "stores";
    }

    @GetMapping("/stores/{event}")
    public String storesCafe(@PathVariable String event, Model model){

        boolean isnumber = event.matches("[0-9]+");
        System.out.println(isnumber);
        if(!isnumber) {
            List<Store> lists = JdbcConnection.findByEvent(event);
            model.addAttribute("lists", lists);
            return "stores";
        }
        else{
            Store store = JdbcConnection.findById(event);
            model.addAttribute("lists", store);
            return "store";
        }
    }



}
