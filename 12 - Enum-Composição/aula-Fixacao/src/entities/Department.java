package entities;

public class Department {
	private String name; //nome
	
	public Department() { // padrão do construtor
		
	}

	public Department(String name) { // construtor com argumento
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
