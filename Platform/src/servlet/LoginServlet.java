package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Login;
import model.Loginlogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		Login login = new Login(name, pass);
		Loginlogic bo = new Loginlogic();
		boolean result = bo.execute(login);

		LoginDAO d = new LoginDAO();

		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("userId", d.findByLogin(login).getUserId());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Mainplatform.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/Platform/LoginServlet");
		}
	}
}
