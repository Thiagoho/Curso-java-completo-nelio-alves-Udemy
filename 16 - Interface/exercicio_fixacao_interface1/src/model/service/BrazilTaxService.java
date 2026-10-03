package model.service;
// aqui implementamos a class TaxService se notar o sistema para o Estados Uni.. já esta configurada com seu imposto.
public class BrazilTaxService implements TaxService {
	// aqui estamos imprementanto a regras de imnposto
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		} else {
			return amount * 0.15;
		}
	}
}
