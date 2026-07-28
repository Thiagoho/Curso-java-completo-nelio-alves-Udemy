package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;



public class Program {

	public static void main(String[] args) {
		//1
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new  ArrayList<>();  //Interface 
		System.out.print("How many employee will be registered? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Employee #" +i+1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			//6
			while (hasId(list,id)) {
				System.out.println("Id already taken! Try again;");
				 id = sc.nextInt();
			} // 6
			
			
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp); // add a lista de employee -> Funcionario 
			
		} //1
		
		//3
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		
//5
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);// 5 
		//Integer pos = position(list, idsalary);
		
		if(emp == null) { // troca pos para emp
			System.out.println("This id does not exist.");
			
		} else {
			System.out.print("Enter the percentagem.");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent); // troca list.get(pos) para emp
			
		}//3
				
		// 4
		System.out.println();
		System.out.println("List of employees: ");
		for (Employee e : list) { // 5 Não posso usar emp tem troca e
			System.out.println(emp);
		} //4
				
		sc.close();
	}
	//2
	// função auxiliar
	public static Integer position(List<Employee> list, int id) { // Para sabe onde esta a posição do io 
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null; //2
	}
	// 6 mostra 
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	} //6
}
