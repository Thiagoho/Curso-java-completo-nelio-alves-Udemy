package entities;

public class Company extends TaxPayer { // empresa

	private int numberOfEmployees; // número de funcionários

	
	public Company() {
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	/*
	 * Pessoa jurídica: pessoas jurídica pagam 16% de imposto. Porém, se a employee
	 * possuir mais de 10 funcionarios, ela para 14% de imposto. Em: um empresa cuja
	 * renda foi 40000.00 e possui 25 funcionarios, o imposto fica 40000 * 14% =
	 * 560000.00
	 */
	@Override
	public double tax() {
		if (numberOfEmployees > 10) {
			return getAnualIncome() * 0.14;
		}
		else {
			return getAnualIncome() * 0.16;
		}
	}

}
