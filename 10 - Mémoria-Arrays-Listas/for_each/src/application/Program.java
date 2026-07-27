package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		
	
		String[] vector = new String[] { "Maria", "Bob", "Alex" };
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
		System.out.println();

		// LEITURA: "para cada objeto 'obj' contido em vector, faca:"
		for (String obj : vector) {
			System.out.println(obj);
		}

		sc.close();
	}

}
