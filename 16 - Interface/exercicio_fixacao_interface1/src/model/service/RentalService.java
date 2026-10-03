package model.service;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	// Trazendo a compusição
	private BrazilTaxService bts;
	
// aqui não posso usar o construtor padrão quero obrigatar ele usar o construtor com argumento.

	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService bts) {

		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.bts = bts;
	}
	
	// aqui agora criamos a logica do processInvoice
	public void proceesInvoice(CarRental carRental) {
		// Aqui entra a lógica
		carRental.setInvoice(new Invoice(50.0, 10.0)); // Aqui estamos mostrando o valor de fatura.
	}
}
