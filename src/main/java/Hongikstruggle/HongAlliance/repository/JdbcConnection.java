package Hongikstruggle.HongAlliance.repository;

import Hongikstruggle.HongAlliance.domain.Store;
import Hongikstruggle.HongAlliance.domain.StoreForm;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcConnection {

    private static String USERNAME;
    private static String PASSWORD;
    private static String URL;
    private static String DRIVER;

    @Value("${db.username}")
    public void setUSERNAME(String username) { USERNAME = username; }

    @Value("${db.password}")
    public void setPASSWORD(String password) { PASSWORD = password; }

    @Value("${db.url}")
    public void setURL(String url) { URL = url; }

    @Value("${db.driver-class-name}")
    public void setDRIVER(String driver) { DRIVER = driver; }


    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            System.out.println("정상적으로 db에 연결되었습니다.");
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("db에 연결할 수 없습니다..");
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
                store.setInfo(rs.getString("info"));
                store.setPicture(rs.getString("picture"));
                store.setLat(rs.getDouble("lat"));
                store.setLng(rs.getDouble("lng"));
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
                store.setInfo(rs.getString("info"));
                store.setPicture(rs.getString("picture"));
                store.setLat(rs.getDouble("lat"));
                store.setLng(rs.getDouble("lng"));
                store.setKind(event);
                list.add(store);
            }
            System.out.println("selection 정상 작동!");
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
        }
        return list;
    }

    public static Store findById(String id){
        String sql = "select * from store where sid =" + id + ";";

        System.out.println(sql);
        Store store = new Store();

        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            store.setId(rs.getInt("sid"));
            store.setName(rs.getString("sname"));
            store.setKind(rs.getString("kind"));
            store.setInfo(rs.getString("info"));
            store.setPicture(rs.getString("picture"));
            store.setLat(rs.getDouble("lat"));
            store.setLng(rs.getDouble("lng"));
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
            System.out.println(e);
        }
        return store;

    }

    public static void PostNewStore(StoreForm form){

        String newid = JdbcConnection.Getmaxnewid();

        String sql = "insert into newstore(newid, sname,info,kind,position) values(" + newid + ",'" + form.getName() + "','" + form.getInfo() + "','" + form.getKind() +"','" +form.getPosition() + "');";
        try{
            Statement stmt = getConnection().createStatement();
            stmt.execute(sql);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(sql);
    }

    public static String Getmaxnewid(){
        Integer max_id = null;

        String sql = "select max(newid) from newstore";

        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            max_id = rs.getInt("max(newid)")+1;
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
            System.out.println(e);
        }

        return Integer.toString(max_id);
    }

    public static String Getmaxid(){
        Integer max_id = null;

        String sql = "select max(id) from store";

        try{
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            max_id = rs.getInt("max(id)")+1;
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
            System.out.println(e);
        }

        return Integer.toString(max_id);
    }

}
