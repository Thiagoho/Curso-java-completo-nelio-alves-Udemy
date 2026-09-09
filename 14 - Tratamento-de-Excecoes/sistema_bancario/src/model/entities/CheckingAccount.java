package model.entities;

import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;
// Herança
public class CheckingAccount extends Account { // Conta correte
	private Double limit; // limit

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(String name, String cpf, int accountNumber, Double balance, Double limit) {
		super(name, cpf, accountNumber, balance);
		this.limit = limit;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		// tratamento se
		if (limit < 0) {
			throw new InvalidAmountException("Limit cannot be negative."); // O limite não pode ser negativo.
		}
		this.limit = limit;
	}

// Sobrescrita do método de saque 
	// polimorfismo
	@Override
	public void withdraw(double amount) { // [saque] e [quantia]
		// O Saldo disponivel real é o saldo atual + o limit
		if (amount <= 0) {
			throw new InvalidAmountException("\twithdraw amount must be greater than zero"); // O valor do saque deve ser
																							// maior que zero.
		}
		double totalAvailable = getBalance() + limit;

		if (amount > totalAvailable) {
			throw new InsufficientBalanceException("\tInsufficient balance and limit for this withdrawal."); // Saldo e
																											// limite
																											// insuficientes
																											// para este
																											// saque
		}
		setBalance(getBalance() - amount);
	}

// Retorn quanto o cliente ainda pode gastar.
	public double getTotalAvailable() {
		return getBalance() + limit;
	}

	// Depois a CheckingAccount acrescenta seus próprios dados.
	@Override
	public String toString() {
		return """ 
				%s 
				Limit: R$ %.2f
				total deposit: R$ %.2f
				""".formatted(super.toString(), limit, getTotalAvailable());
						}

}
