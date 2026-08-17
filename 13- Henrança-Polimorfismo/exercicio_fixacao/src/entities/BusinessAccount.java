package entities;

public class BusinessAccount extends Account { // Negocios --> Business
	 private Double loanlimit; // Limite de empréstimo
	 
	 public BusinessAccount() {
		 super();
	 }

	 public BusinessAccount(Integer number, String holder, Double balance, Double loanlimit) {
		super(number, holder, balance);
		this.loanlimit = loanlimit;
	 }

	 public Double getLoanlimit() {
		 return loanlimit;
	 }

	 public void setLoanlimit(Double loanlimit) {
		 this.loanlimit = loanlimit;
	 }
	public void loan(Double amount) {
		if (amount <= loanlimit) {
			balance += amount - 10.0;
		}
	}
	 
	// Vamos cubra um valor 2 R$ na retirada do valor atual  
	 @Override
	 public void withdraw(double amount) {
		 super.withdraw(amount);
		 balance -= 2.0;
		 
	 }

}
