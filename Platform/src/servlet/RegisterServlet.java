package servlet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.RegisterUserLogic;
import model.User;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aoplat\", \"root\", \"1234");

			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?)");

			ps.setString(1, name);
			ps.setString(2, pass);
			int i = ps.executeUpdate();

			if (i > 0) {
				out.println("“o˜^‚³‚ê‚Ü‚µ‚½!");
			}

		} catch (Exception se) {
			se.printStackTrace();
		}

	}
}