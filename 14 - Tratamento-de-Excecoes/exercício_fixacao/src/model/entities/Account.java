package model.entities;

import exceptions.BusinessException;

public class Account { // Conta
	private Integer number; // Numero
	private String holder; // titular
	private Double balance; // saldo
	private Double withdrawLimit; // limite de saque.


public Account() {}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
// Métodos
	public void deposit(double amount) { // depositar
		
		this.balance += amount;
	}
// Métodos
	public void withdraw(double amount) { // retirar
		validateWithdraw(amount); // [1] Estamos passando uma exceção 'Se passar realiza o saque
		balance -= amount;
	}
// Vamos criar um exceção 
	private void validateWithdraw(double amount)  {
// [1] se não mostra o erro.
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Erro withdraw: the amount exceeds withdraw limit."); // A quantid
		}
		if (amount > getBalance()) {
			throw new BusinessException ("withdraw error: Not enough balance.");
		}
	}
}
