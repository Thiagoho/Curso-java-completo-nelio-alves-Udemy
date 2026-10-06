package model.service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

/*Gera as parcelas mensais, calcula as taxas e as adiciona diretamente ao objeto Contract.*/

public class ContractService {
	// Dependencia injetada por maio da interface
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onnlinePaymentService) {
		this.onlinePaymentService = onnlinePaymentService;

	}

	public void processContract(Contract contract, int months) {
		// Calcula a cota básica dividindo o valor total pelo número de meses
		double basicQuota = contract.getTatolValue() / months; // calcula o valor basico de cada pacela dividindo o
																// valor total do contrato pelo numero de meses.

		// Inicia o laço repetição(for) que vai rodar de 1 até o numero total de meses
		// (uma iteração para cada parcela.)

		for (int i = 1; i <= months; i++) {

			// Avança os meses a partir da data vencimento do contrato
			LocalDate dueDate = contract.getDate().plusMonths(i); // Calcula a data de vencimento da parcela atual
																	// adicionado i meses à data original do contrato.

			// Aplica os juros simples referentes aos mês atual
			double interest = onlinePaymentService.interest(basicQuota, i); // Chama o servico de pagamento
																							// para calcular os juros
																							// simples referentes ao mês
																							// atual i
			// sobre o valor basico da parcela.

			// Aplica a taxa de pagamento fixo sobre o valor atualizado da cota
			double free = onlinePaymentService.paymentFee(basicQuota + interest); // Calcula a taxa pagamento baseado no
																					// valor da parcela já acrescido dos
																					// juros.

			double quota = basicQuota + interest + free; // Soma o valor basico, os juros e a taxa para obter o valor
															// total final desta parcela especifica.

			contract.getInstallments().add(new Installment(dueDate, quota)); // Cria um novo lista de parcelas do
																				// contrato.

		}
	}

}
