package dataDrivernTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class readDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		//create driver instance
		Driver dbDriver = new Driver();
		
		//step2. register to JDBC Driver
		DriverManager.registerDriver(dbDriver);
		//step3.Establish JDBC Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		
		//step4. create Statement
		Statement statement = connection.createStatement();
		
		//step5. Execute Query to fetch data
		ResultSet result = statement.executeQuery("select * from student");
		
		while(result.next()) {
System.out.println(result.getInt("sid")+"\t"+result.getString("sname")+"\t"
		+result.getString("phno")+"\t"+result.getString("course"));
		}
		//step6.close database
		connection.close();
		}
		
	}


