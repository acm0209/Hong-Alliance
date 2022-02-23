package Hongikstruggle.HongAlliance.repository;

import Hongikstruggle.HongAlliance.domain.Store;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

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
        }catch(Exception e){
            System.out.println("selection 오류 발생!");
            System.out.println(e);
        }
        return store;

    }

    public void PostNewStore(String sname, String info){
        String sql = "insert into newstore(sname,info) values(" + sname + "," + info + ");";

        System.out.println(sql);
    }

}
