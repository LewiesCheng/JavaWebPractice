package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentCl;

/**
 * Servlet implementation class StudentClServlet
 */
@WebServlet("/StudentClServlet")
public class StudentClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String password = request.getParameter("newPassword");
			String student = (String)request.getSession().getAttribute("sId");
			
			StudentCl studentCl = new StudentCl();
			if(studentCl.updatePassword(student, password)){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("failure.jsp").forward(request, response);
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
