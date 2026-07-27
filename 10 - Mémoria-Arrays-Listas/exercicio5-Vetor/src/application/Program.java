package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double soma, media;
		// Quantos números vai ser digitado
		System.out.print("How many numbers will be entered?");
		int n = sc.nextInt();
		double[] vector = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number:"); // Insira um número.
			vector[i] = sc.nextDouble();
		}
		soma = 0.0;
		for (int i = 0; i < n; i++) {
			soma = soma + vector[i];
		}
		media = soma / n;
		System.out.print("Values: ");
		for (int i = 0; i < n;i++) {
			System.out.printf("%.1f ", vector[i]);
		}
		
		System.out.printf("\nSum: %.2f\n", soma);
		System.out.println("average: "+ media);
		sc.close();
	}

}
