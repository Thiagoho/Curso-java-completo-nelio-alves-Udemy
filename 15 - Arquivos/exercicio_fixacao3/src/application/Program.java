package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IO;
import java.io.IOException;

/* BLOCO TRY-WITH-RESOURCES
 * É um bloco try que declara um ou mais recursos, e garante que esses 
 * recursos serão fechados ao final do bloco
 * 
 * Dispovivel no java 7 em diante
 * 
 *
 * Vamos trabalha dessa maneira, seria o jeito correto.*/

// Dica "Aqui estamos somente lendo o arquivo que criando na pasta C:...,
public class Program {
	void main() {
		// Aqui seria o caminho para esse arquiv.
		String path = "C:\\Users\\Thiago Sales\\OneDrive\\Área de Trabalho\\Estudo & Java\\in.txt";

		// Aqui vmaos trazer o FileReader fr = null; e ufferedReader br = null; para
		// dentro do truy
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// BufferedReader(recebe o new FileReader(String path -> seria localizado o
			// arquivo)
			// Nós criando uma String line, vai ser uma linha reedLIne-> Se estiver no final
			// ele return null.
			String line = br.readLine();

			// A Sequencia da logica
			while (line != null) {
				IO.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			IO.print("Error: " + e.getMessage());
		}

	}

}
