package application;

import java.io.IO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	void main() {
	Locale.setDefault(Locale.US);
		// O conceito de uma class abstract não pode ser instânciada. 		
//		Account acc1 = new Account(1001, "Alex", 1000.0); // Mostrando não pode instaciar minha class Account por ela esta com abstract
//		IO.println(acc1);
//		
//		Account acc2 = new SavingsAccount(1002, "Mario", 1000.0, 0.01); // Conta poupança
//		IO.println(acc2);
//		
//		Account acc3 = new BusinessAccount(1003, "Thiago", 100.0, 500.0);
//		IO.println(acc3);
	
	/* Demo: soponha que você queira:
	 * totalizar o saldo de todas as contas.
	 * depositar 10.00 em todas as contas. 
	 * */
		
		// Note com a List com consegui fazer uma manipulação da class Account.
		List<Account> list = new ArrayList<>();// Com list a Account fica génerico.
		list.add(new SavingsAccount(1002, "Mario", 1000.0, 0.01)); // Conta poupança
		list.add(new BusinessAccount(1003, "Thiago", 1000.0, 500.0));
		list.add(new SavingsAccount(1004, "Aline", 1000.0, 502.0));
		list.add(new BusinessAccount(1005, "Thalia", 1000.0, 503.0));
		
	//	list.add(new Account(1002, "Maria", 1100.0, 0.01));// Tentar trazer Account passando dentro da list ocorre errro por a class Account esta Abstract.
	
		double sum = 0.0; // Criando um variavél
		
		for (Account acc : list) {
			sum += acc.getBalance(); // totalizar o saldo de todas as contas. 
		}
		for (Account acc : list) { // depositar 10.00 em todas as contas. 
			acc.deposit(10.0); 
		}
		
		IO.println("Total balance: " + sum);
		for (Account acc : list) {
			IO.println("update balance for accound %d: %.2f%n".formatted(acc.getNumber(), acc.getBalance()));
		}
		
	}
	
	
	
}
