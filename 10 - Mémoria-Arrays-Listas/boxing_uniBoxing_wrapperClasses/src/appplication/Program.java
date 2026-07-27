package appplication;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//Boxing É o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível 
		int x = 20; 
		
		// Uniboxing É o processo de conversão de um objeto tipo referência para um	objeto tipo valor compatível
		Object obj = x;
		int y = (int) obj; 
		
		
		//As Wrapper Classes pertencem ao pacote java.lang e servem para "envelopar" um tipo primitivo em um objeto.
		// Byte, Short, Integer, Long, Float, Double, Character e Boolean 
		Integer objs = x;
		
		
		Scanner sc = new Scanner(System.in);


		System.out.println("Boxing: " + x);
		
	
		
		System.out.println("Unboxing " + obj);
		
		System.out.println("Wrapper classes " + y); // Wrapper Classes;
		sc.close();
	}

}
