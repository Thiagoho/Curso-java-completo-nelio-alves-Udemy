package application;

import java.io.IO;
import java.util.Locale;
import java.util.Scanner;

import exceptions.BusinessException;
import model.entities.Account;

/*Fazer um programa para ler os dados de uma conta bancária e depois realizar
 * um seque nesta conta bancário, mostrando novo saldo. Um saque não pode ocorrer
 * ou se não houver saldo na conta, ou se valor do saque for superior ao limite de 
 * saque da conta. Implemente a conta bancária conforme projeto abaixo.*/
public class Program {
	void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
			IO.println("Enter account data"); // Informe os dados da conta.
			
			IO.print("Number: "); // número
			int number = sc.nextInt();
			
			IO.print("Holder: "); // titular
			sc.nextLine();
			String holder = sc.nextLine();
			
			IO.print("Initial balance: "); // saldo inicial
			double balance = sc.nextDouble();
			
			IO.print("Withdraw limit: "); // limite de saque
			double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			IO.println();
			IO.print("Enter amount for Withdraw: "); // Informe uma quantidade para sacar
			double amount = sc.nextDouble();
			// Chama a função de saque
			try {
			acc.withdraw(amount);
			IO.print("New balance: " + String.format("%.2f%n", acc.getBalance()));
		} catch (BusinessException e) {
			IO.print(e.getMessage());
		}
		sc.close();
	}

}
