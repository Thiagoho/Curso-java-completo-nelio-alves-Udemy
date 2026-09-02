package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date chechIn;
	private Date chechOut;
	
	// Estamos formatando a data 
	// static para não ser distancia em outra class, vai ser distancia somente aqui na class Resertion.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {}
	
	public Reservation(Integer roomNumber, Date chechIn, Date chechOut) {
		this.roomNumber = roomNumber;
		this.chechIn = chechIn;
		this.chechOut = chechOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

// Aqu8i não void deixar as data não seja mudar arbitrariamente. " vou ter um métodos para isso"
	public Date getChechIn() {
		return chechIn;
	}

	

	public Date getChechOut() {
		return chechOut;
	}

	// Aqui vamos fazer um conta. Temos que fazer um macetinho de data calcular.
	public long duration() {
		// Como impletar as diferença entre duas data?
		long diff = chechOut.getTime() - chechIn.getTime(); // aqui esta fazendo o calculo em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // agora transforma para dia;
		
	}
	
	// Aqora devemos atualizar as data novo do checkIn e chechOut.
	public void updateDates(Date chechIn, Date chechOut) {
		// Aqui estamos passando como argumentos.
		this.chechIn = chechIn;
		this.chechOut = chechOut;
	}

	@Override
	public String toString() {
		return  roomNumber + ", chech in= " +sdf.format(chechIn) + ", chechOut= " + sdf.format(chechOut) + ", " + duration() + " nights";
	}
	

}
