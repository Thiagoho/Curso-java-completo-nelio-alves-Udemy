package entities;

public class Register {
	
	private String name;
	private String email;

	
	public Register(String name, String email) {
		this.name = name;
		this.email = email;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return name + ", email=" + email;
	}
	
	
	
}
