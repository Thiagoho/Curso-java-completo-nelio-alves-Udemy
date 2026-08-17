package entities;

public class SavingsAccount extends Account { // Savings -> Poupança
	private Double interesRate; // Taxa de juro

	public SavingsAccount() {
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

	// Aqui estamos somando balance, depois multiplicando [balance * interesRate], estamos atualizando o 'balance'
	public void updateBalance(int amount) {
		balance += balance * interesRate;
	}
	
	// Agora vamos criar um metodos não desconta o valor e 5%
	@Override // Seria uma sobre posição.
	public void withdraw(double amount) {
		balance -= amount;
	}
}
