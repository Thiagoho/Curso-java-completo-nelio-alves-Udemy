package application;

import java.io.IO;

import entities.Cachorro;
import entities.Gato;

public class Program {
	void main() {
		IO.println("Hello");
		//Animal an = new Animal("Rex"); Não funciona essa class passamos abstract
		
		Cachorro cachorro = new Cachorro("Rex ");
		IO.println(cachorro);
		IO.println();
		IO.println("Cachorro");
		cachorro.dormir();
		cachorro.emitirSom();
		//Resultado: 
//		Rex esta dormindo.
//		Au au!
//		Perceba algo muito importante.
//		Nós não fizemos:
//		new Animal()
//		Mas o cachorrro esta usando:
//		dormir()
//		que foi criado dentro de Animal.
		
		IO.println("Gato");
		Gato cat = new Gato("Thor ");
		cat.dormir();
		cat.emitirSom();
	
	}

}
