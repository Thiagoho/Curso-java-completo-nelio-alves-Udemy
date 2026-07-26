package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n, qdtHomens, qdtMulheres;
		double menorAltura, maiorAltura, alturafemMedia, alturafemTotal;
		
		System.out.print("Quantas pessoas serao digitadas? ");
		n = sc.nextInt();
		
		double[] altura = new double[n];
		char[] genero = new char[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("Altura da %da pessoa: " ,i+1);
			altura[i] = sc.nextDouble();
			
			System.out.printf("Genero da %da pessoas" ,i+1);
			genero[i] = sc.next().charAt(0);
		}
		menorAltura = altura[0];
		maiorAltura = altura[0];
		
		for (int i = 0; i < n; i++) {
			if (altura[i] > maiorAltura) {
				maiorAltura = altura[i];
			} if (altura[i] < menorAltura) {
				menorAltura = altura[i];
			}
			
		}
		qdtHomens = 0;
		qdtMulheres = 0;
		alturafemTotal = 0;
		for (int i = 0; i < n; i++) {
			if (genero[i]== 'M') {
				qdtHomens++;
			}
			else {
				qdtMulheres ++;
				alturafemTotal = alturafemTotal + altura[i];
			}
		}
		alturafemMedia = alturafemTotal / qdtMulheres;
		
		System.out.printf("Menor altura = %.2f\n", menorAltura);
		System.out.printf("Maior altura = %.2f\n", maiorAltura);
		System.out.printf("Média das alturas das mulheres = %.2f\n", alturafemMedia);
		System.out.printf("Número de homens = %d\n", qdtHomens);
		
sc.close();
	}

}
