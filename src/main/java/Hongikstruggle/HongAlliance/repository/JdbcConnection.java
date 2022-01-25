package Hongikstruggle.HongAlliance.repository;

import Hongikstruggle.HongAlliance.domain.Store;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "jhwwjd9*";
    private static final String URL = "jdbc:mysql://localhost:3306/hong_alliance_db";


    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("정상적으로 db에 연결되었습니다.");
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("db에 연결할 수 없습니다.");
        }
        return null;
    }

    public static List<Store> findAll(){

        String sql = "select * from store";
        List<Store> list = new ArrayList<>();

        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Store store = new Store();
                store.setId(rs.getInt("sid"));
                store.setName(rs.getString("sname"));
                store.setKind(rs.getString("kind"));
                list.add(store);
            }
            System.out.println("selection 정상 작동!");
        } catch(Exception e){
            System.out.println("selection 오류 발생!");
        }
        return list;

    }

    public static List<Store> findByEvent(String event){
        String sql = "select * from store where kind ='" + event + "';";
        List <Store> list = new ArrayList<>();

        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Store store = new Store();
                store.setId(rs.getInt("sid"));
                store.setName(rs.getString("sname"));
                store.setKind(event);
                list.add(store);
            }
            System.out.println("selection 정상 작동!");
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
        }
        return list;
    }




}
