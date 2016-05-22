package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCl {

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
	 * 验证学生用户是否存在
	 * @param student 学号
	 * @param password 登录密码
	 * @return
	 */
	public boolean checkUser(String student, String password){
		boolean b = false;
		
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sPassword from student where sId = '"+ student +"'");
			
			if (resultSet.next()) {
				
				if (resultSet.getString(1).equals(password)) {
					
					b = true;
					
				}
				
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
	
	/**
	 * 
	 */
	public String getName(String student) {
		String name = null;
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sName from student where sId = '"+ student +"'");
			
			if (resultSet.next()) {
				
				name = resultSet.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			//关闭资源 
			this.close();
		}
		return name;
	}
	
	public String getDept(String student) {
		String dept = null;
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select sDept from student where sId = '"+ student +"'");
			
			if (resultSet.next()) {
				
				dept = resultSet.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			//关闭资源 
			this.close();
		}
		return dept;
	}
}
