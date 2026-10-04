package model.service;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;
/*	[1]
 *  Aqui no construtor tem invensão de controle e injeção de dependencia
 * Inversão de controle -> Padrão de desenvolvimento que consiste em retirar da classe a 
 * responsabilidade de instanciar sua dependencias.
 * 
 * Injeção de dependencia 
 * É uma forma de realizar a inversão de controle: um componente externo instancia a dependencia, que é então
 * injetada no objeto "pai". Pode ser implementada da várias formas:
 * --> Construtor
 * --> Classe de instanciação (builder/factory)
 * --> Container / frameWork
 * */
public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	// Trazendo a compusição
	private TaxService bts; // Trocamos para de BrazilTaxService para TaxService
	
// aqui não posso usar o construtor padrão quero obrigatar ele usar o construtor com argumento.
																//[1]	aqui injeção de dependencias
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService bts) {

		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.bts = bts;
	}
	
	// aqui agora criamos a logica do processInvoice
	public void proceesInvoice(CarRental carRental) {
		// Aqui entra a lógica do [Pagamento]
		// O sistema tem que trazer para minutos 
										// aqui vindo class CarRental  -> passando para minutos               
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60.0; // Aqui estamos dividindo minutes por 60 sera uma hora.
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours); // Aqui ficar somente nas 12 horas ele paga mais barrato
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0); // Aqui se passar de 24 horas ele paga mais caro.
		}
		//Agora logica do Imposto
		double tax = bts.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment,tax)); // Aqui estamos mostrando o valor de fatura.
	}
}
