import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class gradesConnection {
	static ResultSet yap() {
		ResultSet myRs = null;
		String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
		String user = "sqlserveray";
		String password = "nomad344";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Veri girildi !");
			Statement statement = connection.createStatement();
			myRs = statement.executeQuery("select * from notlar");
		} catch (Exception e) {
			System.out.println("Bir hata belirdi !"
					+ "\n asdasd");
			e.printStackTrace();
		}
		return myRs;
	}
}
