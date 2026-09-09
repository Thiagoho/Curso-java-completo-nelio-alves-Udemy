package model.entities;

import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;
 // Herança
public class SavingsAccount extends Account { // conta poupança
	private double yieldRate; // taxa de rendimento

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String name, String cpf, int accountNumber, Double balance, double yieldRate) {
		super(name, cpf, accountNumber, balance);
		if (yieldRate < 0) {
			throw new InvalidAmountException("Yeild rate cannot be negative"); // A taxa de rendimento não pode ser
																				// negativa.
		}
		this.yieldRate = yieldRate;
	}

	public double getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(double yieldRate) {
		// tratamento com if
		if (yieldRate <= 0) {
			throw new InvalidAmountException("Yield rate cannot be negativo."); // A taxa de rendimento não pode ser
																				// negativa.
		}
		this.yieldRate = yieldRate;
	}

	// Regra de saque da poupança
	// polimorfismo
	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new InvalidAmountException("Withdrawal amount must be greater than zero."); // O valor do saque dever
																								// ser maior que zero
		}
		if (amount > getBalance()) {
			throw new InsufficientBalanceException("Insufficient balance for this withdraw."); // Saldo insuficiente
																								// para este saque
		}
		setBalance(getBalance() - amount);
	}

	public void calcularYield() {
		// Aqui estamos multiplicando depois dividindo. 
		double income = getBalance() * yieldRate / 100;
		setBalance(getBalance() + income);

	}
	// yiel rate -> taxa redimento
	//Dento do formatted, usamos %% para imprimir o caractere % EX: 5.00%
	@Override
	public String toString() {
		return """
				%s 
				Yield rate: %.2f%%
				""".formatted(super.toString(), yieldRate);
			
	}
}
