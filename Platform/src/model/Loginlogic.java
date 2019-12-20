package model;

import dao.LoginDAO;

public class Loginlogic {

	public boolean execute(Login login) {
		LoginDAO dao = new LoginDAO();
		User user = dao.findByLogin(login);
		return user != null;

	}

}
