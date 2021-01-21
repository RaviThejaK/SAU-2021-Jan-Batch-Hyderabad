import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StoreDetailsJDBC {

	public static void main(String[] args) throws SQLException {
	
		String jdbcUrl = "jdbc:mysql://localhost:3306/javaassignment?useSSL=false";
		String user ="root";
		String pwd="Mysql@21";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl,user,pwd);
			System.out.println("Successfully connected to My Sql DB");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

// the following is for creating, inserting updating and reading the data in tables.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaassignment", "root", "password-here")) {
																													// **changed my password 
				StoreDetailsJDBC storeDetailsJDBC =  new StoreDetailsJDBC();
//				storeDetailsJDBC.createTables(con);
				storeDetailsJDBC.insertData(con);
				//storeDetailsJDBC.updateData(con);
				//storeDetailsJDBC.readData(con);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	private static void createTables(Connection con) {
		try (Statement stmt = con.createStatement()) {
			String sql = "create table javaassignment(asgmt_id int PRIMARY KEY, name varchar(100), review varchar(100))";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private static void insertData(Connection con) {

		String sql = "insert into assignment(asgmt_id, name, review) values(?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, 1);
			stmt.setString(2, "advanced_java");
			stmt.setString(3, "yet to begin");
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateData(Connection con) {
		String sql = "update assignment set review=? where asgmt_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "started");
			stmt.setInt(2, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void readData(Connection con) {
		String sql = "select asgmt_id, name, review from assignment";
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


