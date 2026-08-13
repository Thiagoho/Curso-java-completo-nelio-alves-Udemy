package application;

import java.io.IO;

import entites.Account;
import entites.BusinessAccount;
import entites.SavingsAccount;

public class Program {
  void main() {
	  
	  Account acc = new Account(1001, "Thiago", 0.0);
	  BusinessAccount bacc = new BusinessAccount(1002, "Alinie", 0.0, 500.0);
	  
	  //            UpCasting
	  
	  // Estamos pegando um objeto bacc e atribuindo para um objeto acc
	  
	  // Ex:  Esse exemplo esta Usando a Herença [Account -> BusinessAccount], isso acontece de ligação.
	  Account acc1 = bacc; // Note que não deu erro
	  
	  // Ex: Agora passar o new BusinessAccount -> objeto
	  Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 230.0);
	  
	  // Agora se nós usarmos o SavingsAccount tentar usar no account vai funcionario.
	  Account acc3 = new SavingsAccount(1004, "Marciel", 0.0, 0.01);
	  
	  
	  // 			DownCasting

	  // Note que na operacão Account não tem loan. O loan somente na operação BusinessAccount
	  // Se você tentar acc2.loan -- da erro.
	  
	 // BusinessAccount acc4 = acc2; // Nota que o compilador não a aceita
	  BusinessAccount acc4 = (BusinessAccount) acc2; // Agora dessa maneira da Certo
	  acc4.loan(100.0);
	  // Ela ex: São permitida no console 'run --> nota que console <terminated>
	  
	  // Tal check 
	  // Na hora que da um run nota que ocorre um erro.
	//  BusinessAccount acc5 = (BusinessAccount) acc3; // Nota que acc3 vêm da class-> SavingsAccount não da class -> BusinessAccount.
	 // Como resolver essa erro aqui? BusinessAccount acc5 = (BusinessAccount) acc3;
	 // BusinessAccount acc5 = (BusinessAccount) acc3;
	  // 	Palavra instanceof
	  // Temos que fazer um tratamento de ecessão
	  if (acc3 instanceof BusinessAccount) {
		  // Aqui criamos uma variavel acc5 para ver ele e da class BusinessAccount
		  BusinessAccount acc5 = (BusinessAccount) acc3;
		  acc5.loan(200.0);
		  IO.println("Loan!");
	  }
	  // Agora estou distânciando para saber ele é SavingsAccount
	  if(acc3 instanceof SavingsAccount) {
		  SavingsAccount acc5 = (SavingsAccount) acc3;
		  acc5.updateBalance(0);
		  IO.println("Update!"); // Nota que ele dispara essa mensagem de -> Update
	  }
	  
  }
}
