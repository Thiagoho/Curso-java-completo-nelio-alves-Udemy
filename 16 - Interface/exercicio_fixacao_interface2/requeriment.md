

---------------------------------------------------------------------
Classe PaypalService (Pacote model.services)
Implementa a interface aplicando 1% de juros simples por mês e 2% de taxa de pagamento.
java
package model.services;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02; // Taxa de 2%
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * 0.01 * months; // Juros simples de 1% ao mês
    }
}
---------------------------------------------------------------------------
3. Classe ContractService (Pacote model.services)
Gera as parcelas mensais, calcula as taxas e as adiciona diretamente ao objeto Contract.
java
package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    // Dependência injetada por meio da interface
    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {
        // Calcula a cota básica dividindo o valor total pelo número de meses
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            // Avança os meses a partir da data de vencimento do contrato
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // Aplica os juros simples referentes ao mês atual
            double updatedQuota = basicQuota + paymentService.interest(basicQuota, i);
            
            // Aplica a taxa de pagamento fixa sobre o valor atualizado da cota
            double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);

            // Adiciona a parcela na lista interna do contrato
            contract.addInstallment(new Installment(dueDate, fullQuota));
        }
    }
}
-----------------------------------------------------------------------------------------------------------
. Programa Principal Atualizado (Program)
Lê o número de meses, aciona a execução dos serviços e imprime o resultado na tela utilizando o formato padrão de data.
java
package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: "); 
        Integer number = sc.nextInt();
        
        sc.nextLine(); // Consome a quebra de linha pendente do nextInt()
        
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt); 
        
        System.out.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();
        
        // Cria a instância da entidade Contract
        Contract contract = new Contract(number, date, totalValue);
        
        System.out.print("Entre com o numero de parcelas: ");
        Integer months = sc.nextInt();
        
        // Instancia o serviço injetando a implementação do Paypal
        ContractService contractService = new ContractService(new PaypalService());
        
        // Processa o contrato gerando as parcelas modificadas por juros e taxas
        contractService.processContract(contract, months);
        
        System.out.println();
        System.out.println("PARCELAS:");
        
        // Percorre as parcelas criadas e exibe na tela
        for (var installment : contract.getInstallments()) {
            System.out.println(installment.getDueDate().format(fmt) + " - " + String.format("%.2f", installment.getAmount()));
        }
        
        sc.close();
    }
}