package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int nmonores;
		double alturatotal, alturamedia, porcentualMenores;

		System.out.print("How many numbers will be entered? ");
		int n = sc.nextInt();

		String[] name = new String[n];
		int[] age = new int[n];
		double[] height = new double[n];

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Personal %da details:\n", i + 1);

			sc.nextLine();
			System.out.print("Name: ");
			name[i] = sc.nextLine();

			System.out.print("Age: ");
			age[i] = sc.nextInt();

			System.out.print("Height: ");
			height[i] = sc.nextDouble();
		}
		nmonores = 0;
		alturatotal = 0;
		// Criando a função da media da altura.
		for (int i = 0; i < n; i++) {
			if (age[i] < 16) {
				nmonores++;
			}
			alturatotal = alturatotal + height[i];
		}

		alturamedia = alturatotal / n;
		porcentualMenores = ((double) nmonores / n) * 100;
		System.out.printf("\nAltura média = %.2f\n", alturamedia);
		System.out.printf("Person under 16 years the age of 16: %.1f%%\n", porcentualMenores);

		// Trazendo somente os names foram menores que 16 anos
		for (int i = 0; i < n; i++) {
			if (age[i] < 16) {
				System.out.printf("%s\n", name[i]);
			}
		}

		sc.close();
	}

}
