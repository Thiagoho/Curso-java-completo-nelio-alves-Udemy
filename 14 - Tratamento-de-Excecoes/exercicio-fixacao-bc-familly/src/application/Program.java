package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IO;
import java.util.Scanner;

public class Program {
	void main() {
		
		// File mostra um arquivo de txt, esta nessa pasta.
		File file = new File("C:\\Users\\Thiago Sales\\OneDrive\\Área de Trabalho\\Estudo & Java\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				IO.println(sc.nextLine());
			}
		} catch(FileNotFoundException e ) { // Exceção de arquivo não encontrado
			IO.println("Erro pening file:" + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
			IO.print("Finally block executed");
		}
	}
}
