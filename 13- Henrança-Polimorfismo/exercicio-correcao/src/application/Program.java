package application;

import java.io.IO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<TaxPayer>();

		IO.print("Enter the number of taxPayers: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			IO.println("TaxPayer #" + i + "data:");
			IO.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			IO.print("Name: ");
			String name = sc.next();
			IO.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (ch == 'i') {

				IO.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();

				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				IO.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}

		}
		IO.println();
		IO.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			IO.println(tp.getName() + ": $" + String.format("%.2f", tp.tax()));

		}
		System.out.println();
		double sum = 0.0;
		for (TaxPayer tp : list) {
			sum += tp.tax();
		}
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}
}
