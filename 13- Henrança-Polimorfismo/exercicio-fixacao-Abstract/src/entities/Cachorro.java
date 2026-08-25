package entities;

import java.io.IO;

public class Cachorro extends Animal {
	public Cachorro() {
		super();
	}

	public Cachorro(String nome) {
		super(nome);
	}

	@Override
	public void emitirSom() {
		IO.println("Au au!");
	}

}
