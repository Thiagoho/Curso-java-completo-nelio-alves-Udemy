package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n, maiorIdade, posicionar;
		
		System.out.print("Quantos você vai digitar: ");
		n = sc.nextInt();
		
		String[] nomes = new String[n];
		int[] idade = new int[n]; 
		for(int i = 0; i < n; i++) {
			System.out.printf("Dados da %da pessoa\n" , i + 1);
			System.out.print("Nome: ");
			nomes[i] = sc.next();
			
			System.out.print("Idade: ");
			idade[i] = sc.nextInt();
			
		}
		maiorIdade = idade[0];
		posicionar = 0;
		for (int i = 0; i < n; i++) {
			if (idade[i] > maiorIdade) {
				maiorIdade = idade[i];
				posicionar = i;
			}
			
		}
		System.out.printf("PESSOA MAIS VELHA: %s\n", nomes[posicionar]);
		
		sc.close();

	}

}
