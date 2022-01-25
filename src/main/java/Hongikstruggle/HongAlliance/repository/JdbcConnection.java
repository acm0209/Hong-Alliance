package Hongikstruggle.HongAlliance.repository;

import java.sql.*;

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

}
