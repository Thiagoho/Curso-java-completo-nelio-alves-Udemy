package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	
		System.out.print("How many numbers are you going to type?");
		int n = sc.nextInt();
		int[] vector = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Rent#: "+ i + ".");
			System.out.print("Enter a number:");
			vector[i] = sc.nextInt();
		}
		
		System.out.println();
		System.out.print("Negative number:");
		for (int i = 0; i < n; i++) {
			if(vector[i] < 0) {
				System.out.printf("%d\n", vector[i]);
				
			}
		}
		sc.close();

	}

}
