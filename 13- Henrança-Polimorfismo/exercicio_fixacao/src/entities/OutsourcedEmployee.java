package entities;

public class OutsourcedEmployee extends Employee { // Funcionario Terceirizado
	private double additionalCharce; // encargo adicional
	
	public OutsourcedEmployee() {
		super();
	}


	public OutsourcedEmployee(String name, Integer hours, double valuePerHour, double additionalCharce) {
		super(name, hours, valuePerHour);
		this.additionalCharce = additionalCharce;
	}




	public double getAdditionalCharce() {
		return additionalCharce;
	}


	public void setAdditionalCharce(double additionalCharce) {
		this.additionalCharce = additionalCharce;
	}


	// Aqui estamos resolvendo o funcionario terceirizado ainda recebem um bônus correspondente a 110% de sua despesa aadicional.
	@Override
	public double payment() { // Pagamento + chance adicional * 110%
		return super.payment() + additionalCharce * 1.1;
	}
}
