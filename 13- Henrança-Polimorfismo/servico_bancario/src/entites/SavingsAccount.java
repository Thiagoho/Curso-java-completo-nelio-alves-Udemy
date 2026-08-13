package entites;

public class SavingsAccount extends Account {
	private Double interesRate;
	
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
	
	// Aqui estamos somando balance, depois multiplicando [balance * interesRate], estamos atualizando o 'balance'
	public void updateBalance(int amount) {
		balance += balance * interesRate;
	}
	

}
