package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
int n;
double sum, average;
	
		System.out.print("How many elements will the vector have? ");
		n = sc.nextInt();
		
		double[] vector = new double[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			vector[i] = sc.nextDouble();
		}
		sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum = sum + vector[i];
		}
		
		average = sum / n;
		
		System.out.printf("\nAverage for vector %.4f\n", average);
		System.out.print("Below-average elements:");
		for (int i = 0; i < n; i++) {
			if (vector[i] < average) {
				System.out.printf("%.1f\t" , vector[i]);
			}
		}
		
		sc.close();
	}

}
