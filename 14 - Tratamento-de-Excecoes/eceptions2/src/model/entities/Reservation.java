package model.entities;

import java.io.IO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	// Aqu8i não void deixar as data não seja mudar arbitrariamente. " vou ter um
	// métodos para isso"
	public Date getCheckOut() {
		return checkOut;
	}

// Aqui vamos fazer um conta. Temos que fazer um macetinho de data calcular.
	public long duration() {
		// Como implementar as diferença entre duas data?
		long diff = checkOut.getTime() - checkIn.getTime(); // Aqui esta fazendo o calculo em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // agora transforma para dia;

	}

// Aqora devemos atualizar as data novo do checkIn e chechOut.
	public String updatesDates(Date chechIn, Date ChechOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // Estamos tratamento se digitar data passada o sistema vai
															// mandar ele digitar data futurá
			return "Reservation dates for update must be future dates";
			
		}
		if (!checkOut.after(checkIn)) { // Date não for posterior o de chechIN.
			return "check-out de must be after check -in date";

		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // Se o return for null significa  o sistema esta correto.
	}

	@Override
	public String toString() {
		return roomNumber + ", chech in= " + sdf.format(checkIn) + ", chechOut= " + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}

}
