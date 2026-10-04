package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract  "); // Entre os dados do contrato;
		System.out.print("Number: "); // Numero
		Integer number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

		System.out.print("Contract value: ");// Valor do contrato
		Double totalValue = sc.nextDouble();
		Contract contract = new Contract(number, date, totalValue);
		System.out.println("Contract created with number" + contract.getNumber());
		sc.close();

	}

}
