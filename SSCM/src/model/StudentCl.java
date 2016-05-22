package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentCl {

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
	 * �޸�ѧ������
	 * @param student ѧ��
	 * @param password ������
	 * @return
	 */
	public boolean updatePassword(String student, String password){
		boolean b = false;

		try {
			//�������ݿ�
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
			
			//�ر���Դ 
			this.close();
		}
		
		return b;
	}
}
