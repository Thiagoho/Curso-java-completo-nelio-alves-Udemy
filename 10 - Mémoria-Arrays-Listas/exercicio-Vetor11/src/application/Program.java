package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n, soma, qntd;
		double media;
		
		System.out.print("Quantos elementos vai ter o vetor? ");
		n = sc.nextInt();
		
		int[] vector = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Digite um número ");
			n = sc.nextInt();
			
		}
		
		soma = 0;
		qntd = 0;
		
		for (int i = 0; i < n; i++) {
			if (vector[i] % 2 == 0) {
				soma += vector[i];
				qntd++;
				
			}
		}
		if (qntd == 0) {
			System.out.print("NENHUM NÚMERO PAR");
		} else {
			media = (double) soma / qntd;
			System.out.printf("MÉDIA DOS PARES %.1f%n", media);
		}
		sc.close();

	}

}
