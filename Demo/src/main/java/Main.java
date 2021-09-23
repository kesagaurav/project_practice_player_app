import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
	//loading an driver class
		Connection con=null;
		System.out.println("hello gaurav");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\n driver loaded successfully");
			String url="jdbc:mysql://localhost:3306/player";
			String username="root";
			String password="1234";
			try {
				con=DriverManager.getConnection(url, username,password);
				System.out.println("\n connection established");
				
				// step -3 
				Statement s=con.createStatement();
				String sql="select player_id,name,age,gender,city,sportsName,contact from player order by player_id desc";
				
				// step - 4
				// exceute query
				ResultSet  rs=s.executeQuery(sql);
				System.out.println("\n successfully created the query database ");
				//step -5 exceute process
				while(rs.next()) {
					System.out.println(" id " + rs.getInt("player_id"));
					System.out.println(" name " + rs.getString("name"));
					System.out.println(" age " + rs.getInt("age"));
					System.out.println(" gender " + rs.getString("gender"));
					System.out.println(" city " + rs.getString("city"));
					System.out.println(" sportsNamae " + rs.getString("sportsName"));
					System.out.println(" contact " + rs.getLong("contact"));
					
				}
				System.out.println("\n results processed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			// step -6 will close the connection
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
