package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CourseBean;
import model.CourseBeanCl;
import model.LoginCl;



/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {			
			
			String requestPage = (String)(request.getParameter("requestPage"));
			if(requestPage.equals("student")) {
				
				try {
					LoginCl loginCl = new LoginCl();
					
					String dept = loginCl.getDept((String)request.getSession().getAttribute("sId"));
					request.setAttribute("dept", dept);
					request.getRequestDispatcher("student.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (requestPage.equals("course")) {
				
				try {
					CourseBeanCl courseBeanCl = new CourseBeanCl();
					ArrayList<CourseBean> arrayList = courseBeanCl.getCourse("all", null);
					request.setAttribute("course", arrayList);
					request.getRequestDispatcher("selectCourse.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			} else if (requestPage.equals("select")) {
				
				try {
					
					CourseBeanCl courseBeanCl = new CourseBeanCl();
					ArrayList<CourseBean> arrayList = courseBeanCl.getSelectiveCourse((String)request.getSession().getAttribute("sId"));
					request.setAttribute("course", arrayList);
					request.getRequestDispatcher("selective.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else if (requestPage.equals("quit")) {
				//°²È«ÍË³ö
				HttpSession httpSession = request.getSession(true);
				httpSession.removeAttribute("sName");
				httpSession.removeAttribute("sId");
				response.sendRedirect("login.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
