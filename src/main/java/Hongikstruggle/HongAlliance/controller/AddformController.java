package Hongikstruggle.HongAlliance.controller;

import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.repository.JdbcConnection;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Hongikstruggle.HongAlliance.repository.JdbcConnection.getConnection;

@Controller
public class AddformController {

    @GetMapping("/addform")
    public String addform(){return "addform";}

    @PostMapping("/addform")
    public String postform(Store form){

        System.out.println(form.getName());
        System.out.println(form.getKind());
        System.out.println(form.getInfo());

        return "/addform";
    }


}
