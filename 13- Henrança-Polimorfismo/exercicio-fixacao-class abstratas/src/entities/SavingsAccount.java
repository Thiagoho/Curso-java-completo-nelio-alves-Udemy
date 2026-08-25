package entities;

public class SavingsAccount extends Account { // Savings -> Poupança
	private Double interesRate; // Taxa de Juro

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interesRate) {
		super(number, holder, balance);
		this.interesRate = interesRate;
	}

	public Double getInteresRate() {
		return interesRate;
	}

	public void setInteresRate(Double interesRate) {
		this.interesRate = interesRate;
	}

	// Aqui estamos somando balance, depois multiplicando [ balance * interesRate].
	public void updateBalance(int amount) {
		balance += balance * interesRate;
	}

	// agora vamos criar um métodos ñ desconta o valor de 5%.
	@Override // Seria um sobreEscrita.
	public void withdraw(double amount) {
		balance -= amount;
	}
}
