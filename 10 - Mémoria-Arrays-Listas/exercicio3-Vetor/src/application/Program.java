package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Register;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Register[] vect = new Register[10]; 
		System.out.print("Wow mony rooms will be rented? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Rent #" + i + ":");
			sc.nextLine();
			System.out.print("Name:");
			String name = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.println("Room: ");
			
			int room = sc.nextInt();
			
			vect[room] = new Register(name, email);
					
		}
		
		System.out.println();
		System.out.print("Busy rooms: ");
		for (int i = 0; i < 10; i++) {
			if (vect[i] != null) {
				System.out.println(i + ": " + vect[i]);
			}
		}
		sc.close();

	}

}
