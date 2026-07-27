package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n, posmaior;
		double maior;
		
		System.out.print("Quantos numeros voce vai digitar? ");
		n = sc.nextInt();
		
		double[] vector = new double[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Digite um nuero: ");
			vector[i] = sc.nextDouble();
		
		}
		 
		 
		maior = vector[0];
		posmaior = 0;
		
		for (int i = 0; i < n; i++) {
			if (vector[i] > maior) {
				maior = vector[i];
				posmaior = i;
			}
		}
		System.out.printf("Maior valor %.1f\n", maior);
		System.out.printf("Posicao do maior valor = %d\n", posmaior);
		sc.close();
	}

}
