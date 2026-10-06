package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment { // parcela

	private LocalDate dueDate; // data de vencimento
	private Double amount; // quantia

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Cria um formatador para converter o texto
																		// digitado pelo usuario em uma data
																		// valida(LocalDate)

	public Installment(LocalDate dueDate, Double amount) {

		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
	}

}
