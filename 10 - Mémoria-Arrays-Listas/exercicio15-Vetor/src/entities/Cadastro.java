package entities;

public class Cadastro {
	private String nome;
	private String email;
	
	public Cadastro(String nome, String email) {

		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "" + nome + "" + email;
	}
	
	
	

}
