package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

private Connection connection = null;
	
	public Connection getConnect(){
		
		try {
			
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�õ�����
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sscm", "root", "liuchengsql");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}
}
