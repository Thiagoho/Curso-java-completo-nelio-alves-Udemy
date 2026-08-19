package application;

import java.io.IO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();
		IO.print("Enter the number of Empoyee: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			IO.println("Employee # " + i + "data");
			IO.print("Outsourced (y/n)?");
			char ch = sc.next().charAt(0);

			IO.print("Name: ");
			sc.nextLine();// quebra de linha
			String name = sc.nextLine();

			IO.print("Hour: ");
			int hours = sc.nextInt();

			IO.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			if (ch == 'y') {
				IO.print("Additional charge");
				double additionalCharge = sc.nextDouble();

				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge)); // Funcionario
																								// Terceirizado
			} else {
				list.add(new Employee(name, hours, valuePerHour)); // Funcionario
			}

		}
		IO.println();
		IO.println("PAYMENT");
		for (Employee emp : list) {
			IO.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		sc.close();
	}

}
