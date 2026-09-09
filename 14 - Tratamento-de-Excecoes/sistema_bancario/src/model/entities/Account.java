package model.entities;

import model.exceptions.InvalidAmountException;
import model.exceptions.InvalidCpfException;
import model.exceptions.InvalidNameException;

// Toda conta precisa saber sacar, mas a classe Account não define exatamente como cada tipo fará isso.

public abstract class Account { // Conta
	// Encapsulamento
	private String name; // nome
	private String cpf;
	private int accountNumber; // numero da conta
	private double balance; // Saldo

	public Account() {
	}

	public Account(String name, String cpf, int accountNumber, Double balance) {
		if (balance <= 0) {
			throw new InvalidAmountException("Initial balance cannot ne negative."); // O saldo inicial não pode ser
																						// negativo.
		}
		setName(name); // Agora o construtor também utiliza a nossa regra.
		setCpf(cpf);
		this.name = name;
		
		this.cpf = cpf;
		
		
		
		
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	// Getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateName(name); // add método de validação.
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		validateCpf(cpf);
		this.cpf = cpf;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}
// Setter somente para o que decidimos permitir alteração

	/*
	 * Método protegito. Somente Acoount e suas classes filhas poderão alterar
	 * diretamnente o saldo.
	 * 
	 * o Mian não poderá fazer: conta.setBalance(...)
	 */
	protected void setBalance(double balance) {
		this.balance = balance;
	}

// Deposito
	public void deposit(double amount) { // amount --> quantia

		if (amount <= 0) {
			throw new InvalidAmountException("Deposit amount must be greater than zero."); // O valor do deposito deve
																							// ser maior que Zero.
		}
		balance += amount;
	}

	// Estamos criando um método de validação reutilizável na setName() usa essa
	// regra.
	public static void validateName(String name) {
		// Fazendo a validação se digitar numeros automacamente mostra essa mensagem.
		if (name == null || name.isBlank()) {
			throw new InvalidNameException("Name cannot be empty."); // O nome não pode ser vazio.
		}
		if (!name.matches("[\\p{L} ]+")) {
			throw new InvalidNameException("Name must contatin only letters."); // O nome deve conter apenas letras.
		}
	}
	/* Criando validateCpf()
	-> CPF não pode ser vazio
	-> Deve possuir exatamente 11 digitos.
	-> Deve aceitar somente números.*/	
	public static void validateCpf(String cpf) {
		if (cpf == null || cpf.isBlank()) {
			throw new InvalidCpfException("CPF cannot be empty."); // O CPF não pode estar vazio.
		}
		 if (!cpf.matches("\\d+")) {
				throw new InvalidCpfException("CPF must contain only number"); // O CPF deve conter apenas números.
		 }
		 if (cpf.length() != 11) {
			 throw new InvalidCpfException("CPF must contain exacty 11 digits."); // cpf deve conter exatament 11 digitos.
		 }
	}
	
	

	/*
	 * Método abstrado.
	 * 
	 * Cada tipo de conta será responsável pelo sua própria regra de saque.
	 */
// Abstracao
	public abstract void withdraw(double amount);

	// Execute primeiro o toString() da minha classe mãe Account.
	// Account details -> Dado da conta.
	@Override
	public String toString() {
		return """
				\t\t==== Account details ====
				Nome: %s CPF: %s Account number: %s balance: R$ %.2f""".formatted(name, cpf, accountNumber, balance);
	}

}
