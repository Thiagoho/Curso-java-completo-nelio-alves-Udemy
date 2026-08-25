package entities;

import java.io.IO;

public class Gato extends Animal {

	public Gato(String nome) {
		super(nome);
	}
	
	@Override
	public void emitirSom() {
		IO.println("Miau miau!");
	}

}
