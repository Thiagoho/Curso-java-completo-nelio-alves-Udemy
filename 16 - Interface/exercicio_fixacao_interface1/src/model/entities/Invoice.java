package model.entities;

public class Invoice { // fatura
	private Double basicPayment; // Pagamento básico
	private Double tax; // imposto

	public Invoice() {
	}

	public Invoice(Double basicPayment, Double tax) {

		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	// Aqui uso o padrão do get
	// Uso o get porque no futura quiser mudar oa lógica já esta ponto aqui.
	public Double getTotalPayment() { // Pagamento total
		return getBasicPayment() - getTax();
	}

}
