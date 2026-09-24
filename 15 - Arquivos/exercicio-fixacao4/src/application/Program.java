package application;
/* FILEWRITER & BUFFEREDWRITER
 * FileWriter (stream de escrita de caracteres em de arquivos)
 * Cria/recria o arquivo:
 * 
 * */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IO;
import java.io.IOException;

public class Program {
	void main() {
		// creando um vetor de String
		String[] lines = new String[] { "Good Morning", "Good agternoon", "Good night" };
		// Quero criar um arquivo de salvar esse dados aqui.

		// Primeiro temos que informar o caminho do arquiv
		String path = "C:\\Users\\Thiago Sales\\OneDrive\\Área de Trabalho\\Estudo & Java\\in.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { // true ele faz recriar o arquivo.
			// Agora vamos salvar a linha do arquiv
			for (String line : lines) {
				bw.write(line); // Escreve essa minha no meu arquivo
				// Aqui temos add porque ele não tem quebra de linhas
				bw.newLine();

			}
			IO.println("Aquivo Criado com sucesso");
		}

		// TRatamento de excesão
		catch (IOException e) {
			e.printStackTrace(); // mostrar algum erro
		}
	}
}
