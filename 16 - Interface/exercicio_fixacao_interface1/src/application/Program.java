package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter the rental details:"); // Entre com os dados do aluguel

		System.out.print("Car model: "); // Modelo do carro
		// criei uma String carModel
		String carModel = sc.nextLine();
		System.out.print("Pick-up (dd/MM/yyyy HH:mm) "); // Retirada
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

		System.out.print("Return (dd/MM/yyyy HH:mm): "); // Retorno
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

		CarRental cr = new CarRental(start, finish, new Vehicle(carModel)); // aqui new vehicle(model), passando um
																			// argumento da class Veicle

		System.out.println("Enter the hourly rate: "); // Entre com o preço por hora:
		double pricePerHour = sc.nextDouble();
		System.out.println("Enter the price per day: "); // Entre com o preço por dia;
		double pricePerDay = sc.nextDouble();

		// Vamos distanciar o RentalServicer aquj

		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService()); // Aqui add a dependencia do BrazilTaxService.
		// Aqui agora estamos chamando o rs --> RentalService
		 // esse processInvoice esta distanciando os dados fisico da minha public void precessInvoice ele esta na class -> RentalService
		rs.proceesInvoice(cr);
		System.out.println("\t\tFatura:");
		// Aqui estamo ligando as tables RentalService -> Invoice -> getBasicPayment 
		System.out.println("basic payment: "+ cr.getInvoice().getBasicPayment()); // Pagamento basico: 
		System.out.println("Tax: " + cr.getInvoice().getTax()); // Imposto
		System.out.println("full payment: " + cr.getInvoice().getTotalPayment()); // pagamento total
		sc.close();
	}

}
