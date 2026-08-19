package entities;

public class Employee { // Funcionário
	private String name; // Nome
	private Integer hours; // hora
	private double valuePerHour; // valor por hora
	
	public Employee() {
		
	}

	public Employee(String name, Integer hours, double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public double payment() { // pagamento
		// Estamos multiplicando hora * valor por hora.
		return hours * valuePerHour;
	}
}
