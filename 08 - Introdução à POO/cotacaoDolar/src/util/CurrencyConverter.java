package util;

public class CurrencyConverter {
	public static final double IOF = 0.06;
	
	public static double calcularDolarToReal(double amount, double dolarPrice) {
		return amount * dolarPrice *(1.0 + IOF);
	}
}
