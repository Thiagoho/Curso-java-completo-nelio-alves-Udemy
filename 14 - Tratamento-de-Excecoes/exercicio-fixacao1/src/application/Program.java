package application;

import java.io.IO;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	void main() {
		Scanner sc = new Scanner(System.in);
		// Estamos trabalhando com vetor. esse 'split' aceitar espaço
		try {
		String[] vect = sc.nextLine().split(" ");
		int position = sc.nextInt();
		IO.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) { // Erro seria mostrando quando o usuário digitar um número de pessoas não tem. Exem: 3 pessoa ele digitar 4 mostra a mensagem.
			IO.println("Invalid position!");
		}
		catch (InputMismatchException e) { // Erro mostra quando digitar letras.
			IO.println("Input error");
		}
		//
		IO.println("End of Program");
		sc.close();
	}

}
