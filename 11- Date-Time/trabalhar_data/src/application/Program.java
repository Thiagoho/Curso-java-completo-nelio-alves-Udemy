package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
		/* Aqui criei uma função onde mostrar a data e hora atual na tela*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY HH:mm:ss");
		Date date = new Date();
		System.out.println("Date " + sdf.format(date) + " Hora atual.");
	}

}
