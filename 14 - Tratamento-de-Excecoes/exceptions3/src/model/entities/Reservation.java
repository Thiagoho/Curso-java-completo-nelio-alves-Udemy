package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}
//[1] Usar o RuntimeException[model.exceptions.DomainException] não vamos mais precisar do throw DomianException nas class
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) /*throws DomainException*/ { // Add o thows
																									// DomainException
																									// aqui na class. 
		// Aqui podemos fazer um tratamento de exceção, seria programação defensiva boa
		// pratica. Essa função ele seria disparada quando o usuario digitar data errado
		// no cadastro check-out or check-in.
		if (!checkIn.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
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

	// Aqu8i não void deixar as data não seja mudar arbitrariamente. " vou ter um
	// métodos para isso"
	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// Aqui vamos fazer um conta. Temos que fazer um macetinho de data calcular.
	public long duration() {
		// Como implementar as diferença entre duas data
		long diff = checkOut.getTime() - checkIn.getTime(); // Aqui esta fazendo o calculo em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // agora transforma para dia.

	}

	// Agora devemos atualizar as data novo do checkIn e checkOut. // Tivemos que
	// add na class throws IllegalAcessException.
	//[1]
	public void updatesDates(Date checkIn, Date checkOut) /* throws DomainException*/ { // Aqui agora vamos trocar o
																					// String para void.

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // Estamos tratamento se digitar data passado o sistema vai
															// mandar ele digitar data futura
			throw new DomainException("Reservation dates for update must be future dates"); // Vamos lançar uma
			// ERRA:IllegalAccessException passamos para DomainException // exceção. Usando
			// a
			// IllegalAcessException

		}
		if (!checkOut.after(checkIn)) { // Data não for posterior do checkIn
			throw new DomainException("Check-out de must be after check-in date"); // Vamos lançar uma exceção.
			// ERRA:IllegalAccessException passamos para DomainException // Usando a
			// IllegalAcessException
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		// return null; // Se o trurn for null o sistema esta correto.

	}

	@Override
	public String toString() {
		return roomNumber + ", chech in= " + sdf.format(checkIn) + ", chechOut= " + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}
}
