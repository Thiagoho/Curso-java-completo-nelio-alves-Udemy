package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {


		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Cria um formatador para converter o texto digitado pelo usuario em uma data valida(LocalDate)

		System.out.println("Enter contract  "); // Entre os dados do contrato;
		System.out.print("Number: "); // Numero
		Integer number = sc.nextInt();
		sc.nextLine();

		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt); // Lê o texto da data e o transforma em um objeto
																// LocalDate usando o formatador fmt.

		System.out.print("Contract value: ");// Valor do contrato
		Double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue); // Cria (intancia) o objeto do contrato na maneira
																	// com o número, data e valor digitados.

		System.out.print("Enter the number of installments: "); // Entre com o numero de parcelas;
		int n = sc.nextInt();

		// Cria o serviço de contrato passando um instancia de PayPalService para dentro
		// dele. Isso é o injeção de dependência, permitindo que o serviço use as regras
		// de juros do Paypal.
		ContractService contractService = new ContractService(new PaypalService());

		// Execute a lógica que você viu anteriormente: calcula o valor de cada parcela
		// com os juros e adiciona-as dentro do objeto contract.
		contractService.processContract(contract, n);

		System.out.println();
		System.out.println("Installments: ");// parcelas

		for (Installment installment : contract.getInstallments()) { // Inicia um laço do tipo for-each que percorre
																		// cada parcela gerada dentro da lista de
																		// parcelas do contrato.

			System.out.println(installment); // Imprime a parcela atual na tela (chama implicitamente o método
												// toString() da classes Installment).
		}
		sc.close();

	}

}
