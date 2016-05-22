package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.CourseBean;
import model.CourseBeanCl;

/**
 * Servlet implementation class SelectClServlet
 */
@WebServlet("/SelectClServlet")
public class SelectClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		if(page.equals("search")){
			try {
				
				ArrayList<CourseBean> arrayList = new ArrayList<>();
				CourseBeanCl courseBeanCl = new CourseBeanCl();
				if(request.getParameter("search").equals("all")){
					arrayList = courseBeanCl.getCourse("all", null);
				} else if (request.getParameter("search").equals("recommend")) {
					arrayList = courseBeanCl.getCourse("recommend", (String)request.getSession().getAttribute("sId"));
				}
				request.setAttribute("course", arrayList);
				request.getRequestDispatcher("selectCourse.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (page.equals("select")) {
			
			try {
				
				String[] checkbox = request.getParameterValues("boxes");
				CourseBeanCl courseBeanCl = new CourseBeanCl();
				boolean b = true;
				for(int i=0; i < checkbox.length; i++){
					if(courseBeanCl.selectCourse(checkbox[i], (String)request.getSession().getAttribute("sId")) == false){
						b = false;
						break;
					}
				}
				if(b){
					request.getRequestDispatcher("success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("failure.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (page.equals("drop")) {
			try {
				
				String[] checkbox = request.getParameterValues("boxes");
				CourseBeanCl courseBeanCl = new CourseBeanCl();
				boolean b = true;
				for(int i=0; i < checkbox.length; i++){
					if(courseBeanCl.dropCourse(checkbox[i], (String)request.getSession().getAttribute("sId")) == false){
						b = false;
						break;
					}
				}
				if(b){
					request.getRequestDispatcher("success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("failure.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		this.doGet(request, response);
	}

}
