package entities;

import java.io.IO;

public abstract class Animal {
	private String nome;
	
	public Animal() {}

	public Animal(String nome) {
		super();
		this.nome = nome;
	}
	public void dormir() {
		IO.println(nome + "esta dormindo");
	}
	public abstract void emitirSom();

	@Override
	public String toString() {
		return nome;
	}
	
}
