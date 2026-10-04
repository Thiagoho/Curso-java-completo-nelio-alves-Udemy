package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private Integer number;
	private LocalDate date;
	private Double tatolValue;

	// Representa a associação "-installment" do diagram UML
	
	private List<Installment> installments = new ArrayList<>();
	

	public Contract() {
	}

	public Contract(Integer number, LocalDate date, Double tatolValue) {
		this.number = number;
		this.date = date;
		this.tatolValue = tatolValue;
		
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTatolValue() {
		return tatolValue;
	}

	public void setTatolValue(Double tatolValue) {
		this.tatolValue = tatolValue;
	}



	public List<Installment> getInstallments() {
		return installments;
	}

	

	@Override
	public String toString() {
		return "Cantract [number=" + number + ", Date=" + date + ", tatolValue=" + tatolValue;
	}

}
