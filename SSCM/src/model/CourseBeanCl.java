package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseBeanCl {
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
	
	public ArrayList<CourseBean> getCourse(String need, String student) {

		ArrayList<CourseBean> arrayList = new ArrayList<>();
		
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			statement = connection.createStatement();
												
			if(need.equals("all")){
				resultSet = statement.executeQuery("select * from course;");
			} else if (need.equals("recommend")) {
				resultSet = statement.executeQuery("select * from course where cDept=(select sDept from student where sId='"+student+"')");
			} 
	
			while (resultSet.next()) {
				
				CourseBean courseBean = new CourseBean();
				courseBean.setcNo(resultSet.getString(1));
				courseBean.setcName(resultSet.getString(2));
				courseBean.setcTeacher(resultSet.getString(3));
				courseBean.setcCredit(resultSet.getString(4));
				courseBean.setcTime(resultSet.getString(5));
				courseBean.setcBook(resultSet.getString(6));
				courseBean.setcDept(resultSet.getString(7));
				arrayList.add(courseBean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return arrayList;
	}
	
	public boolean selectCourse(String cNo, String student) {
		boolean b = false;
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			statement = connection.createStatement();								
			
			int i = statement.executeUpdate("insert into selective (sId,cNo) value ('"+student+"','"+cNo+"')");
	
			if (i == 1) {
				
				b =true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return b;
	}
	
	public ArrayList<CourseBean> getSelectiveCourse(String student) {

		ArrayList<CourseBean> arrayList = new ArrayList<>();
		
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			statement = connection.createStatement();
												
			resultSet = statement.executeQuery("select course.* from sscm.course,sscm.selective where sId='"+student+"' and course.cNo=selective.cNo;");
	
			while (resultSet.next()) {
				
				CourseBean courseBean = new CourseBean();
				courseBean.setcNo(resultSet.getString(1));
				courseBean.setcName(resultSet.getString(2));
				courseBean.setcTeacher(resultSet.getString(3));
				courseBean.setcCredit(resultSet.getString(4));
				courseBean.setcTime(resultSet.getString(5));
				courseBean.setcBook(resultSet.getString(6));
				courseBean.setcDept(resultSet.getString(7));
				arrayList.add(courseBean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return arrayList;
	}
	
	public boolean dropCourse(String cNo, String student) {
		boolean b = false;
		try {
			//链接数据库
			connection = new ConnectDB().getConnect();
			statement = connection.createStatement();								
			
			int i = statement.executeUpdate("delete from selective where sId='"+student+"' and cNo='"+cNo+"'");
	
			if (i == 1) {
				
				b =true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			this.close();
		}
		
		return b;
	}
}
