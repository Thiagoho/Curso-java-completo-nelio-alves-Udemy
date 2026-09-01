package application;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Seria o formado diferente d08
		
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Data / Hora para formadar d09
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); // Trazendo o data hora do meu pc.
		
		
		LocalDate d01 = LocalDate.now(); //Data atual
		LocalDateTime d02 = LocalDateTime.now(); // Data / Hora
		Instant d03 = Instant.now(); // Data / Hora GNT Londres
		
		LocalDate d04 = LocalDate.parse("2030-06-23"); // Data quize tanto antiga ou futura
	//	LocalDateTime d05 = LocalDateTime.parse("2026-05-22T02:20:30:10"); // Data / Hora
		Instant d06 = Instant.parse("2023-07-12T12:53:10Z"); //Data / Hora de Londres GNt
		Instant d07 = Instant.parse("2026-10-23T00:23:21-08:45"); // Comparando hora aqui com de Londres
		
		LocalDate d08 = LocalDate.parse("30/07/2026",fmt1); // formado diferente.
	//	LocalDateTime d09 = LocalDateTime.parse("30/07/206 10:04", fmt2); // Data / Hora Local
		LocalDate d10 = LocalDate.of(2026, 7, 23); // Data usando of
		 LocalDateTime d11 = LocalDateTime.of(2026, 7, 29, 10, 40); // Dat / Hora 

		 
		 
		System.out.println("d01 = " + d01.toString()); // Data atual
		System.out.println("d02 = " + d02.toString()); // Data / Hora
		System.out.println("do3 = "+ d03.toString()); // Data / Hora GNT Londres
		System.out.println("do4 = " + d04.toString()); // Data quize tanto antiga ou futura
		//System.out.println("d05 = " + d05.toString()); // Data / Hora
		System.out.println("d05 = " + d06.toString());//Data / Hora de Londres GNt
		System.out.println("d06 = " + d07.toString()); // Mostra o Hora de Londres.
		System.out.println("d08 = " + d08.toString()); // Date não entra o formato
	//	System.out.println("d09 = " + d09.toString()); // Data / Hora Local
		System.out.println("d10 = " + d10.toString());// Data usando of
		System.out.println("d11 = " + d11.toString()); // Dat / Hora
		System.out.println("d06 = " + fmt3.format(d06)); // Trazendo do fmt3 sua formatação data / hora do pc local.
	}



}
