package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n;
		double media;
		
		
		System.out.print("Quantos alunos serão digitados? ");
		n = sc.nextInt();
		
		String[] nome = new String[n];
		double[] not1 = new double[n];
		double[] not2 = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Digite nome, primeiro a segunda nota %do aluno:", i + 1);
			sc.nextLine();
			nome[i] = sc.nextLine();
			not1[i] = sc.nextDouble();
			not2[i] = sc.nextDouble();
		}
		
		System.out.println("Alunos provados");
		for (int i = 0; i < n; i++) {
			media = (not1[i] + not2[i]) /2;	
			if(media >= 6) {
				System.out.printf("%s", nome[i]);	
			}
		}		
	

		sc.close();
		
	}

}
