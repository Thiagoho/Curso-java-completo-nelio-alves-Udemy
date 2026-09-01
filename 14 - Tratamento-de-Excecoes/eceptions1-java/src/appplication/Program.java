package appplication;

import java.io.IO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

// aqui no main temos que add o throws ParseException seria para chamar uma exceção para o 'parse'
// Estou falando que o main pode lancar um exceção tipo thows ParseExcption
public class Program {
	void main() throws ParseException {
			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IO.print("Room number: ");
		int number = sc.nextInt();
		
		IO.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // Estamos transformando para data							
		IO.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		// Estamos que fazer um tratamento de exceção
		// after seria uma métodos teste se data depois da outra. 
		if(!checkOut.after(checkIn)) {
			IO.print("Error in reservation: check-out de must be after check -in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			IO.print("Reservation: Room " + reservation);
			
			// Aqui agora estamo lendo as nova datas
			IO.println();
			IO.println("Enter data to update the reservation:");
			IO.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			IO.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Agora temos que fazer um tratamento de datas passada o sistema mostra um erro.
			// Vamos iniciar o metodos com date seria data de agora.
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) { // Estamos tratamento se digitar data passada o sistema vai mandar ele digitar data futurá
			 IO.print("Error in reservation: Reservation dates for update must be future dates");
			} else if(!checkOut.after(checkIn)) { // Date não for posterior o de chechIN.
				IO.print("Error in reservation: check-out de must be after check -in date");
				
			} else {
			// Estamos atualizando as datas
			reservation.updateDates(checkIn, checkOut);
			IO.print("Reservation: Room " + reservation); 
			}
			
		}
		
		sc.close();
	}

}
