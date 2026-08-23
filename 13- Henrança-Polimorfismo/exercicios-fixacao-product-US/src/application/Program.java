package application;

import java.io.IO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	void main() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		IO.println("\t=====================================");
		IO.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		// List genérica do tipo Product que aceitará qualquer um das subclass
		List<Product> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			IO.println("Poduct #" +i);
			IO.print("Comon, used or imported (c/u/i)");
			char ch = sc.next().charAt(0);
			IO.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			IO.print("Price: ");
			double price = sc.nextDouble();
			
			// Verifica o tipo para criar o objeto correto.
			if (ch == 'c') {
				list.add(new Product(name, price));
				
			} 
			else if (ch == 'u') {
				IO.print("Manufacture date (DD/MM/YYYY): ");
				String dateStr = sc.next();
				// Converte o texto digitado em um objeto LocalDate
				LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				list.add(new UsedProduct(name, price, date));
			} else if (ch == 'i' ) {
				IO.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		IO.println();
		IO.println("PRICE TAGS:");
		// Percorre a lista executando o priceTag() de cada objeto (Polimorfismo)
		for (Product prod : list) {
			IO.print(prod.priceTag());
		}
		sc.close();
	}
}
