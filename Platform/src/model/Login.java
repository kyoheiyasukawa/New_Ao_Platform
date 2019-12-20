package model;

public class Login {

	private int userId;
	private  String name;
	private  String pass;

	public Login(String name,String pass) {
		this.name = name;
		this.pass = pass;
	}
	public  Login getInstance() {
		return new Login(name,pass);
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}

	public int getUserId() {
		return userId;
	}

}