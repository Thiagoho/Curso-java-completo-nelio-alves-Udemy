package application;

import java.io.File;
import java.io.IO;
import java.io.IOException;
import java.util.Scanner;
// Aqui estamos fazendo um leitura básica de arquivo.
/*
 * Lendo arquivo texto com classes [File & Scanner]
 * File -> Representação abstrata de um arquivo e seu caminho
 * Scanner -> Leitor de texto
 * IOException (Exception)
 * */
public class Program {
	void main() {
			// objeto passado o caminho C:...                  // o barrra seria o caracteres espeiciais       
		File file = new File("C:\\Users\\Thiago Sales\\OneDrive\\Área de Trabalho\\Estudo & Java\\in.txt");
		Scanner sc = null; // Aqui estou distanciando meu Scanner como null, por enquanto valor inicial
		try {
			sc = new Scanner(file); // Aqui estou informando que Scanner recebe o file como argumento  
			while (sc.hasNextLine()) { // O sc.hasNextLine() estamo pergundo se existem uma nova linha no arquivo.
				 
				IO.println(sc.nextLine()); // Aqui vai imprimir essa linha no arquivo.
			}
			
		}catch (IOException e ) {
			IO.print("Error "  + e.getMessage());
			e.printStackTrace(); // Aqui vai mostrar onde ocorreu erro mais detalhes
		}
		
		// Aqui no finally estamo fechando o Scanner.
		finally {
			if (sc != null) { // Aqui fazendo um tratamento de exceção.
				sc.close();
			}
		}
	}
}
