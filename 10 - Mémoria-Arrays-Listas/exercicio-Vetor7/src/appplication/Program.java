package appplication;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n, par;
		
		System.out.print("Quantos numeros voce vai digitar? ");
		n = sc.nextInt();
		
		int[] vector = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Digite um numero: ");
			vector[i] = sc.nextInt();
		}
		System.out.printf("\tPares são:\n");
		
		par = 0;
		for (int i = 0; i < n; i++) {
			if(vector[i] % 2 == 0) {
				System.out.printf("%d\t", vector[i]);
				par++;
			}
		}
		System.out.printf("\nForam %d, pares:", par);
		sc.close();
	}

}
