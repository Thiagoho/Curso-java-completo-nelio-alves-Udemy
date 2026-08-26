package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures; // Gasto com saúde.

	public Individual() {
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	/* Pessoa fisica: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto.
	 * Pessoas renda de 20000.00 em diante pagam 25% de imposto.
	 * Se a pessoa teve gastos com saúde, 50% destes gastos são abatidos no imposto. 
	 * Exe: uma pessoa cuja renda foi 50000.00 e teve 20000.00 em gastos com saúde, 
	 * o imposto fica (50000 * 25%) - (20000 * 50%) = 11500.00
	 * */
	@Override
	public double tax() {
		double basicTax;
		if (getAnualIncome() < 20000.0) {
			basicTax = getAnualIncome() * 0.15;
		}
		else {
			basicTax = getAnualIncome() * 0.25;
		}
		basicTax -= getHealthExpenditures() * 0.5;
		if (basicTax < 0.0) {
			basicTax = 0.0;
		}
		return basicTax;
	}



}
