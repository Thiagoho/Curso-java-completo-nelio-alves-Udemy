package entities;

import java.time.LocalDate;

public class HourContract { //  contrato Hora por
	private LocalDate date; // Data
	private Double valuePerHour; // Valor por hora
	private Integer hours; // Horas
	
	public HourContract() {}

	public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
		
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		return valuePerHour * hours; // Valor por hora * horas. Aqui saber quantas hora trabalhou Ex: 80 * 10 = 800. Hora Trabalhada 80 X hora atual 10;
	}

}
