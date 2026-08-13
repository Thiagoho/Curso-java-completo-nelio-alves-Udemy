package entites;

public class Account { // conta
	
	private Integer number; // numero
	private String holder; // titular
	protected Double balance; // equilibrio
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
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
	public void withdraw(double amount) { // [withdraw]->retirar  [amount] -> quantia
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}


}
