package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Cadastro;

public class Progra {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Cadastro[] vector = new Cadastro[10];

		int n;
		System.out.print("Hom many will be rented:?"); // Quantos quartos.
		n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Rent #" + i+ ":");
			
			System.out.print("Name: ");
			sc.next();
			String nome =sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.println("Quarto: ");
			int quarto = sc.nextInt();
			vector[quarto] = new Cadastro(nome, email);
			
		}
		System.out.println("Quartos alocados foram:");
		for (int i = 0; i < 10; i++) {
			if(vector[i] != null) {
				System.out.println(i+":"+ vector[i]);
			}
		}

		sc.close();

	}

}
