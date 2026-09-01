package application;

import java.io.IO;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	void main() {

		// method2(); // Estamo chamando o método 2
		method1();
		IO.println("End of Program");
	}

	// Criando método 1
	public static void method1() {
		IO.println("**** Method1 start ****");
		// Agora vamos chamar o método 2
		method2();
		IO.println("**** Method1 end ****");
	}

	// Aqui criamos um métodos usar de exemplo.
	public static void method2() {
		Scanner sc = new Scanner(System.in);
		IO.println("**** Method2 Start ****");
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			IO.println(vect[position]);

		} catch (ArrayIndexOutOfBoundsException e) {// Erro seria mostrando quando o usuário digitar um número de
			IO.println("Invalid position!"); // pessoas não tem. Exem: 3 pessoa ele digitar 4 mostra a mensagem.
			e.printStackTrace();// Mostra onde ocorreu o erro.
			sc.next();
		} catch (InputMismatchException e) { // Errro mostra quando digita letras.
			IO.println("Input error");

		}

		sc.close();
		IO.println("**** Method2 end ****");
	}
	// Aqui no method2 você quiser podemos deixa sem tratamento de exceção seria dessa maneira:
	/*
	 * 	// Aqui criamos um métodos usar de exemplo.
	public static void method2() {
		Scanner sc = new Scanner(System.in);
		IO.println("**** Method2 Start ****");
	
		sc.close();
		IO.println("**** Method2 end ****");
	}*/
}
