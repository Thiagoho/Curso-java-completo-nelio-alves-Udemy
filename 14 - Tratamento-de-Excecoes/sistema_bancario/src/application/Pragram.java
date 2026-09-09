package application;

import java.io.IO;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.CheckingAccount;
import model.entities.SavingsAccount;
import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;
import model.exceptions.InvalidCpfException;
import model.exceptions.InvalidNameException;

public class Pragram {
	void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account = null;
		int option = -1; // opcao
		do {
			try {
				IO.println("\t================================");
				IO.println("\t\t Bank Java ");
				IO.println("\t================================");
				IO.println("1 - Open a checking account"); // Criar conta corrente
				IO.println("2 - Open a savings Account"); // Criar conta poupanca
				IO.println("3 - Deposit");
				IO.println("4 - Withdraw");// Sacar
				IO.println("5 - Check account"); // Consultar conta
				IO.println("0 - exit"); // sair
				IO.print(" Choose the option: "); // Escolha a opcao

				option = sc.nextInt();
				sc.nextLine();
				switch (option) {
				case 1 -> {

					IO.println();
					IO.println("\t ===== Checking account =====");
					String name = null;
					boolean validName = false;
					while (!validName) {
						try {

							IO.print("Name: "); // nome
							name = sc.nextLine();
							account.validateName(name);
							validName = true;
						} catch (InvalidNameException e) {
							IO.println();
							IO.println("Error: " + e.getMessage());
						}
					}

					String cpf = null;
					boolean validCpf = false;
					while (!validCpf) {
						try {
							IO.print("CPF:");
							cpf = sc.nextLine();
							account.validateCpf(cpf);
							validCpf = true;
						} catch (InvalidCpfException e) {
							IO.println();
							IO.println("Error: " + e.getMessage());
						}
					}

					IO.println("Account number: "); // numero da conta
					int accountNumber = sc.nextInt();
					IO.print("Opening balance: "); // saldo inicial
					double balance = sc.nextDouble();
					IO.print("Limit: "); // limite
					double limit = sc.nextDouble();
					account = new CheckingAccount(name, cpf, accountNumber, balance, limit); // conta corrente
					IO.println();
					IO.println("\t Checking account created successfully"); // Conta corrente criada com sucesso.

				}
				case 2 -> {
					IO.println();
					IO.println("\t ===== Savings account =====");
					IO.print("Name: "); // nome
					String name = sc.nextLine();
					IO.print("CPF: ");
					String cpf = sc.nextLine();
					IO.print("Account number: "); // numero da conta
					int accountNumber = sc.nextInt();
					IO.print("Opening balance: "); // saldo inicial
					double balance = sc.nextDouble();
					IO.print("Yield rate (%):"); // Taxa de redimento
					double yieldRate = sc.nextDouble();
					sc.nextLine();
					account = new SavingsAccount(name, cpf, accountNumber, balance, yieldRate);
					IO.println();
					IO.println("Savings account successfully created."); // conta poupanca criado com sucesso.

				}
				case 3 -> {
					if (account == null) {
						IO.println("No registered account"); // nenhuma conta cadastrada
						break;
					}
					IO.print("Amount deposit"); // valor do deposito
					double amount = sc.nextDouble();
					account.deposit(amount);

					IO.println("Desposit successfully completed! "); // Deposit realizado com sucesso!
					IO.println("Current baalance: R$ " + account.getBalance());// saldo atual.
				}
				case 4 -> {
					if (account == null) {
						IO.println("No registered accont."); // Nenhuma conta cadastrada
						break;
					}
					IO.println("Withdrawal amount: "); // Valor do saque
					double amount = sc.nextDouble();
					account.withdraw(amount);
					IO.println("Withdrawal sucessffully completed!"); // Saque realizado com sucesso!
					IO.println("Current balance: R$ " + account.getBalance());

				}
				case 5 -> {
					if (account == null) {
						IO.println("No registered account."); // Nenhuma conta cadastrada.
						break;
					}
					IO.println();
					// IO.println("===== Account details =====");// dados conta
					IO.print(account);

					if (account instanceof CheckingAccount checking) {

						// Aqui estou usando o @Override da class [CheckingAccount] toString.
						checking.toString();
					}
					if (account instanceof SavingsAccount savings) {

						// Aqui estou usando o @Override da class [SavingsAccount] toString.
						savings.toString();
					}

				}
				case 0 -> {
					IO.println("System closed");// Sistema encerrado.
				}

				default -> {
					IO.println("Invalid option..."); // opcão invallida
				}
				}

			} catch (InputMismatchException e) {

				IO.println();
				IO.println("Error: enter only numeric values. "); // digite apenas valores numericos.

				/*
				 * Muito importante : Limpa o valor incorreto que ficou no Scanner.
				 */
				sc.nextLine();

			} catch (InvalidAmountException e) {
				IO.println();

				IO.print("Error: " + e.getMessage());
			} catch (InsufficientBalanceException e) {
				IO.println();
				IO.print("Error: " + e.getMessage());
			}

		} while (option != 0); // E o sistema volta para o menu por causa do seu do-while.
		sc.close();
	}
}
