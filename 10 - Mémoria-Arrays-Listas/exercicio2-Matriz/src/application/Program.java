package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] mat = new int[m][n];
		
		//Loop to read numbers // Laço para ler números
		for (int i = 0; i < mat.length; i++) { // Percorre as linhas
			for (int j = 0; j < mat[i].length; j++ ) { // Percorre as colunas
				mat[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == x) {
					System.out.println("Position" + i + ", " + j + ":"); // Qual seria a linhas colunas x 
				}if (j > 0) { // Quem esta sua esquerdo
					System.out.println("Left: " + mat[i][j-1]);  // seria esquerda
				}if (i < 0) {
					System.out.println("Up: " + mat[i-1][j]); // seria acima
				}if (j < mat[i].length-1) { // Quem esta sua direita
					System.out.println("Rigth: " + mat[i][j+1]); // seria direita
					
				} if (i < mat.length-1) { // Quem esta abaixo
					System.out.println("Down: " + mat[i+1][j]); //seria abaixo
					
				}
				
			}
		}
		
		sc.close();
		

	}

}
