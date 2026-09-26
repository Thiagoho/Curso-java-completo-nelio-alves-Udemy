package application;

import java.io.File;
import java.io.IO;
import java.util.Scanner;

public class Progam {
	void main() {
		Scanner sc = new Scanner(System.in);
		IO.println("Enter a folder path: "); // Digite um caminho de pasta
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		IO.println("getName: " + path.getName()); // Aqui ele imprimi o caminho do arquivo seria in.txt
		IO.println("getParent: " + path.getParent());// Agora quero somente o caminho [Estudo & Java]
		IO.println("getPath: " + path.getPath());// Todos os caminhos completo
		IO.println("getFreeSpace: " + path.getFreeSpace()); // Mostra o espaço livre total bruto do disco.
		IO.println("getUsableSpace: " + path.getUsableSpace()); // Mostra o espaço livre que o seu programa realmente pode usar.
		
		sc.close();
	}
}
