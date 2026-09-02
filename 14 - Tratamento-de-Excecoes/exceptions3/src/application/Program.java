package application;

import java.io.IO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	void main() /*throws ParseException*/ { // Agora qui no throws ParseException não vai precisar. Por que será tratada e não propagada.
		
		// Agora o sistema vai ficar desse jeito aqui.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
		IO.print("Room number: ");
		int number = sc.nextInt();
		// Aqui estamo registrando o cadastro
		IO.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		IO.print("Ckeck-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		
		// Aqui estamo atualizando o cadastro
		IO.print("Reservation: " + reservation);
		IO.println();
		IO.println();
		IO.println("Enter data to update the reservation");
		IO.print("Check-in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		IO.print("Check-out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		
		
		reservation.updatesDates(checkIn, checkOut); // [1] Se tiver alguma exceção aqui vamos fazer catch para trabalhar essa exceção.
		IO.print("Reservation: " + reservation);
		} 
		catch (ParseException e) { // Vamos tratar a exceção simpleDateFormat.
			IO.println("Invalid date format." + e);
		//catch (IllegalAccessException e )  trocamos para DomainException agora estamo tratando a exceção.	
		} catch (DomainException e ) { // [1] Aqui estamos chamando a exceção do reservation ocorre error.
			IO.println("Error in reservation: " + e.getMessage());
		} catch(RuntimeException e) { // Na hora que usuario digitar um letra or data diferente automaticamente dispara um mensagem de erro.
			IO.println("Unexpected error.");
			
		}
		sc.close();
	}

}
