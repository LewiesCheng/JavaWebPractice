package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentCl {

	private Statement statement = null;
	private ResultSet resultSet = null;
	private Connection connection = null;
	
	/**
	 * 关闭资源
	 */
	public void close() {
		
		try {
			
			if(resultSet != null) {
				
				resultSet.close();
				resultSet = null;
			}
			
			if (statement != null) {
				
				statement.close();
				statement = null;
			}
			
			if (connection != null) {
				
				connection.close();
				connection = null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 修改学生密码
	 * @param student 学号
	 * @param password 新密码
	 * @return
	 */
	public boolean updatePassword(String student, String password){
		boolean b = false;

		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			
			statement = connection.createStatement();
			int i = statement.executeUpdate("update student set sPassword='"+password+"' where sId="+student+";");

			if (i == 1) {					
				
				b = true;	
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			//关闭资源 
			this.close();
		}
		
		return b;
	}
}
