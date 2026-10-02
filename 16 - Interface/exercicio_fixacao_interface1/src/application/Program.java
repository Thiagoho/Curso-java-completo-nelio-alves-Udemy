package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;

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
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel)); // aqui new vehicle(model), passando um argumento da class Veicle 
		sc.close();
	}

}
