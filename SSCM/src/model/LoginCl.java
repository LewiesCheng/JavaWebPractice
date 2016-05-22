package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCl {

	private Statement statement = null;
	private ResultSet resultSet = null;
	private Connection connection = null;
	
	/**
	 * �ر���Դ
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
	 * ��֤ѧ���û��Ƿ����
	 * @param student ѧ��
	 * @param password ��¼����
	 * @return
	 */
	public boolean checkUser(String student, String password){
		boolean b = false;
		
		try {
			//�������ݿ�
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
			
			//�ر���Դ 
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
			//�������ݿ�
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
			
			//�ر���Դ 
			this.close();
		}
		return name;
	}
	
	public String getDept(String student) {
		String dept = null;
		try {
			//�������ݿ�
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
			
			//�ر���Դ 
			this.close();
		}
		return dept;
	}
}
