package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] mat= new int[n][n];
		
		//System.out.print("Enter the numbers for the 2x3 matrix:"); // Digite os números para a matriz 2x3
		
		// Loop to read numbers // Laço para ler números
		for (int i = 0; i < mat.length; i++) { // Percorre as linhas 
			for (int j = 0; j < mat[i].length; j++) { // Percorre as colunas
				mat[i][j]= sc.nextInt();
				
			}
		}
		System.out.println("Main diagonal: ");
		System.out.println("-----------------");
		for (int i = 0; i < mat.length; i++) {
	
			System.out.print(mat[i][i]+ ": ");
			
		}
		System.out.println("\n-----------------");
		int count = 0;
		for (int i =0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}
		System.out.println("Negative numbers = "+ count);
		sc.close();

	}

}
