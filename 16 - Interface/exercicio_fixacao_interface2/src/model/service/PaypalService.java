package model.service;
/*Este código é a implementação prática da interface que vimos antes.
 * A classe PaypalService assume o compromisso de aplicar as regras 
 * matemáticas especificas do PayPal:2% de taxa pagamento e 1% de juros simples ao mês.*/

/*Implementa a interface aplicando 1% de juros simples
 * por mês e 2 de taxa de pagamento.
 * 
 * tradutor
 * PaypalService -> Servico do Paypal
 * paymentfee -> taxa de pagamento
 * interest -> juros
 * amount -> quantia
 * */
public class PaypalService implements OnlinePaymentService { // Declara a classe PaypalService e usa a palavra-chave
																// impelemts para avisar ao Java que ela vai seguir
																// obrigamente as regras da interface
																// OnelinePaymentService.

	// São constantes usadas para guardar as taxas do PayPal
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;

	@Override
	public double paymentFee(double amount) { // Define método que recebe o valor da parcela com juros (amount) para
												// calcular a taxa.

		// Mais uma taxa de pagemanto de 2%.
		return amount * FEE_PERCENTAGE; // Calcula e retorn 2% do valor informado (multiplicar por 0.02 é o mesmo que
		// calcular 2/100).
	}

	@Override
	public double interest(double amount, int months) {
		// Aplicando juros simples de 1% a cada parcelas.
		return amount * MONTHLY_INTEREST * months; // O Cálculo: O código pega o valor base (amount), descobre quanto é
													// 1% dele (*
		// 0.01) e multiplica pela quantidade de meses daquela parcela (* months). Se
		// for a parcela do mês 3, por exemplo, o juro será de 3%.
	}

}
