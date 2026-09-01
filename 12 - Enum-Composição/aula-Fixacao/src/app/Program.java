package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
/* Part 1 Esse exemplo Abaixo seria sem digitar mostra na tela 
 	Department dept = new Department("Design");
		Worker worker = new Worker("Alex", WorkerLevel.MID_LEVEL, 1200.0, dept);
		
		HourContract contract1 = new HourContract(LocalDate.of(2018, 8, 20), 50.0, 20);
		HourContract contract2 = new HourContract(LocalDate.of(2018, 6, 13), 30.0, 18);
		HourContract contract3 = new HourContract(LocalDate.of(2018, 8, 25), 80.0, 10);
		
		// Aqui eu addContract.
		worker.addContract(contract1); // 
		worker.addContract(contract2);
		worker.addContract(contract3);
		
		System.out.println("Nome: " + worker.getName()); // Nome da pessoa
		System.out.println("Departamento: " + worker.getDepartment().getName()); // Departamento Design -- > nome: Design
		System.out.println("Ganho para 08/2028 " + String.format("%.2f", worker.income(2018, 8))); // Passamos data o valor ganho tota soma data 8 ano 2018
		*/
		/*Part 2: Ele usando o teclado: */
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");
		
		LocalDate contractDate;// Aqui esta trazendo o formato do "DateTimeFormatter fmt"
		double valuePerHour;
		String monthAndYear; //Mês e ano
		
		int month, year; // Mês Ano
		
		System.out.print("Ente o nome do departamento: ");
		String departmentName = sc.nextLine();
		
		Department dept = new Department(departmentName);
		// Cadastro do funcionário.
		System.out.println();
		System.out.println("Entre os dados do trabalhador: ");
		
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		
		System.out.print("Nível: ");
		WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine());; // Nós criamos no enum WorkerLevel
		
		System.out.print("Salário Base: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, workerLevel, baseSalary, dept);
		
		
		// Aqui onde vai funcionar a logíca do contrato
		System.out.println("Quantos contratos esse trabalhador tem?");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com o dados do contrato #" + i + ":");
			System.out.println();
	
			System.out.print("DATA (DD/MM/YYYY): ");
			contractDate = LocalDate.parse(sc.next(), fmt); // Aqui esta trazendo o formato do "DateTimeFormatter fmt"
			
			System.out.print("Valor por hora: ");
			valuePerHour = sc.nextDouble(); // Hora trabalhada 
			
			System.out.print("Duração de (horas): ");
			int hours = sc.nextInt(); // hora atual;
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract); // Aqui faz o sistema fontar no for quantas vezes ou solicidado pelo usuário.
		}
		System.out.println();
		System.out.print("Entre o ano e mês para calcular o ganho (MM/YYYY): ");
		monthAndYear = sc.next(); //Mês e Ano
		
		month = Integer.parseInt(monthAndYear.substring(0, 2)); // Conta o Mês 'MM'
		year = Integer.parseInt(monthAndYear.substring(3)); // Conta depois do '/ YYYY'
		
		System.out.println("Nome: " + worker.getName()); // Nome -> Pessoa
		System.out.println("Departamento: " + worker.getDepartment().getName()); // Nome do departamento
		System.out.println("Ganho para " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}


	}


