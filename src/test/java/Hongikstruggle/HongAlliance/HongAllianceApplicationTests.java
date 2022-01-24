package Hongikstruggle.HongAlliance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.*;
@SpringBootTest
class HongAllianceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public static void main(String[] args) throws SQLException {
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "jhwwjd9*");


	}


}
