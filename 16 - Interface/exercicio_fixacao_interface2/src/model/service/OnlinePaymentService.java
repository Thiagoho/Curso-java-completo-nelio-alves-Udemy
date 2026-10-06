package model.service;

/*Este código define uma Interface na Java. Uma interface funciona como um 
 * contrato ou um manual de regras: ele diz o que um serviço de pagamento deve fazer, 
 * mas não como fazer. Quem implementar essa interface (como a classe PaypalService) 
 * será obrigado a escrever a lógica matemática dessas duas funções.*/

/*Define o contrato para os serviços de pagamento online.
 *  
 *  tradutor 
 * onlinePaymentService -> Servico de pagamento online
 *  paymentfee -> taxa de pagamento
 *  amount -> quantia
 *  interest -> juros
 *  amount quantia / months meses
 *  */
public interface OnlinePaymentService {

	double paymentFee(double amount); // Declara a assinatura do método que calculará a taxa de pagamento. Ele recebe
										// uma quantia (amount) e retorna o valor da taxa.

	double interest(double amount, int months); // Declara a assinatura do método que calculará a taxta de pagamento.
												// Ele recebe uma quantida (amount) e retorna o valor da taxa.

}
