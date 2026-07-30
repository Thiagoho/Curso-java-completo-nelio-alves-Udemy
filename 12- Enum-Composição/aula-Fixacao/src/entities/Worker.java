package entities;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	private String name; // nomne
	private WorkerLevel level;
	private Double baseSalary; // Base Salario
	
	private Department department; // Trazendo as informação do departamento seria a class Department
	// Dica 1 -- * Seria uma List
	private List<HourContract> contracts = new ArrayList<>(); // Aqui eu passo o argumento seria o 'contracts'
	
	public Worker() { // padrao construtor
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract); // Aqui estou add o contract esta na list
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	public double income(int year, int month) {
		double sum = baseSalary; // Aqui estou pegando o base Salario 'Ele ganha atual'
		
		for (HourContract c: contracts) {
			if (year == c.getDate().getYear() && month == c.getDate().getMonthValue()) { // calculo que pega as informação do mês / Ano lá do contracts. 
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
