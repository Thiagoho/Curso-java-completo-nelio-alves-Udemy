package application;

import java.io.IO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	void main() throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IO.print("Room number: ");
		int number = sc.nextInt();
		IO.print("Check-in date (dd/MM/yy): ");
		Date checkIn = sdf.parse(sc.next()); // Estamos transformando para data
		IO.print("Check-Out date (dd/MMM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); // Estamos transformando para data

		// Estamos fazer um tratamento de exceção
		// after seria um método teste se data depois da outra.
		if (!checkOut.after(checkIn)) {
			IO.print("Error in reservation: check-out de must be after check-in date");

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			IO.println("Reservation: Room " + reservation);
			// Aqui agora estamo lendo as nova datas
			IO.println();
			IO.println("Enter data to update the reservation:");
			IO.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			// Aqui estamos chamando o updatesDates vai return um String
			String error = reservation.updatesDates(checkIn, checkOut);
			if (error != null) {
				IO.print("Erro in reservatio: " + error);
			} else {

				IO.print("Reservation: Room " + reservation);

			}

		}

		sc.close();
	}
}
