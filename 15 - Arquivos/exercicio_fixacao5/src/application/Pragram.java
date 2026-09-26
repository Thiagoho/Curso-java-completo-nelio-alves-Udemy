package application;

import java.io.File;
import java.io.IO;
import java.util.Scanner;

/*Manipulando pacotes com file*/
public class Pragram {
void main() {
	Scanner sc = new Scanner(System.in);
	IO.println("Enter a folder path: "); // Digite um caminho pasta
	String strPath = sc.nextLine(); 
	
	File path = new File(strPath);
	// Aqui vmos criar roda onde pega o caminho do Diretory onde salva meu projeto
	File[] folders = path.listFiles(File::isDirectory); // Aqui File::is.Directory estamos passando para buscar oque for diretory e pasta
	IO.println("FOLDERS:");
	for (File folder : folders) {
		IO.println(folder); // C:\Users\Thiago Sales\OneDrive\Área de Trabalho\Estudo & Java... estão aqui.
	}
	
	// Agora vamos mostrar a lista de arquivo.
	File[] files = path.listFiles(File::isFile);
	IO.println("Files");
	for (File file : files) {
		IO.println(file); // mostrar os arquivos.
	}
	// Agora vamos criar uma subPasta aparti da pasta C:\Users\Thiago Sales\OneDrive\Área de Trabalho\Estudo & Java [Aqui vai add a subpasta
	// Temos que criar uma variavel success
	boolean success = new File(strPath + "\\test").mkdir(); 
	
	// CORRIGIDO: Parênteses fechados corretamente e texto concatenado de forma simples
	IO.println("Diretory created sucessfully: " + success);// Diretory criado com sucesso
	sc.close();
}
}
