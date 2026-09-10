package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IO;
import java.io.IOException;

/*FileReader & BufferedReader
 * FileReader(Stream de leitura de caracteres a partir de arquivos)
 * 
 * BufferedReader(mais rapida)		*/
// Vamos fazer tudo manualmente seria o padrao
public class Program {
	void main() {
		// Aqui seria o caminho para esse arquivo.
		String path = "C:\\Users\\Thiago Sales\\OneDrive\\Área de Trabalho\\Estudo & Java\\n.txt";

		//
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path); // Aqui extanciando o fileR.. (path -> Argumento o caminho do arqui)
			br = new BufferedReader(fr); // Aqui estamos recebendo o fr como argumento.

			// Nós criando uma String line, vai ser uma linha reedLIne-> Se estiver no final
			// ele return null.
			String line = br.readLine();

			// A Seguinte Logica
			while (line != null) { // Quanto o line for diferente ele leu com sucessffully.

				IO.println(line); // imprimi na tela
				// Em seguida ele ler o readLine novamente outra linha.
				line = br.readLine();
			}
		} catch (IOException e) {
			IO.println("Error: " + e.getMessage());

		}
		// Aqui estamos fechando as 2 string fr & br
		finally {
			try { // try/catch 
				if (br != null) // Aqui esta dizendo se for diferente de null -> fecha
					br.close();

				if (fr != null) // Aqui esta dizendo se for diferente de null -> fecha
					fr.close();
			}
			// Aqui IOException ele esta funcionando para o finally se acontecer algum erra
			// mostra esse erro.
			catch (IOException e) {
				e.printStackTrace(); // vai mostra na tela o erro.
			}

		}
	}

}
