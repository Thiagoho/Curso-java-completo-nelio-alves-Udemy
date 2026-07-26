package entities;

import java.text.Format;

public class Account {
	private int number;
	private String holder;
	private double balance;
	
	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}
	
	public Account(int number, String holder, double initialDeposit) {
		this.number = number;
		this.holder = holder;
		deposit(initialDeposit); // Protegendo meu construtor
	}

// o número da conta nunca poderá ser alterado
	public String getNumber() {
		return holder;
	}

	//  Já o nome do titular pode ser alterado
	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}
	
// Por fim, o saldo da conta não pode ser alterado livremente
	public double getBalance(double balance) {
		return balance;
	}

	// Métados;
	
	public void deposit(double amount) { // Regra de negócio altera somente aqui. Seria apenas um ponto de alteração.
		balance += amount;
		// Aqui estou encapsulando somente um ponto da regra do negócio.
	}
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	

public String toString() { 
	return "Account " + number + ", Holder; " + holder + ", Balance: $ " + String.format("%.2f", balance); 
}
}