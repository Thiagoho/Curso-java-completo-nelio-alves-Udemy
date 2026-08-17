package application;

import java.io.IO;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	void main() {
		// ACCCOUNT
		// Estou trazendo o desconto 200 R$ também 5 R$. total 795.0
		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(200.0); // Já passei qual metodos vai pegar withdraw.
		IO.println(acc1.getBalance());

		// Estamos depositando 100 += 900 R$.
		Account acc2 = new Account(90, "Thaigo", 900.0);
		acc2.deposit(100.0); // Trazendo o método deposit.
		IO.println(acc2.getBalance());

		///	SAVINGSACCOUNT
		/// Aqui vai desconta 800 R$ usando a subposicao [Não esta cobrando a taxa no valor de 5%]
		Account acc3 = new SavingsAccount(1002, "Aline", 1000.0, 0.01);
		acc3.withdraw(200.0);
		IO.println(acc3.getBalance());
		
		// BUSINESSACCOUNT
		// Aqui tem uma regra do negócios funciona a regra 'Sistema descontar 5% Account,  withdraw 200 R$, 2 R$ BusinessAccount : total 793.0 R$
		Account acc4 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc4.withdraw(200.0);
		IO.println(acc4.getBalance());
	}
}
