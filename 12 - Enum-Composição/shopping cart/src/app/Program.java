package app;

import java.io.IO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	void main() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		IO.println("Enter cliente data");

		IO.print("Name: ");
		String name = sc.nextLine();

		IO.print("Email: ");
		String email = sc.nextLine();
		IO.print("Birth date (DD/MM/YYYY): ");

		// Temos que transforma com sdf.parse..., por que estamos usando Date
		Date birthDate = sdf.parse(sc.next());

		// Passo 1 distância o Client.
		Client client = new Client(name, email, birthDate);

		IO.println("Enter order data"); // Dados do pedidos.

		IO.print("Status:");
		// Fazendo OrderStatus objeto status = passando OrderStatus.vaLueOf(sc.next);
		// digitar esta no enum;
		OrderStatus status = OrderStatus.valueOf(sc.next());

		IO.println("How many items to this order?");
		int N = sc.nextInt();

		// Passo 3 distância do Order essa associando com o Client
		Order order = new Order(new Date(), status, client);

		for (int i = 0; i < N; i++) {
			IO.println("Enter #" + (i + 1) + "item data: ");

			IO.println("Product name: ");// Nome do product
			sc.nextLine();
			String productName = sc.nextLine();

			IO.println("Product price: "); // valor do Product
			double productPrice = sc.nextDouble();

			IO.println("Quantity: "); // Quantidade de produto
			int quantity = sc.nextInt();

			// Passo 1 distância o Product
			Product product = new Product(productName, productPrice);

			// Passo 2 nós estamos associando com o OrderItem dentro product
			OrderItem it = new OrderItem(quantity, productPrice, product);

			// Agora vamos chamar os order
			order.addItem(it);
		}
		IO.println();
		IO.println(order); // Aqui esta chamando lá do Oder a toString mensagem bid lá.
		sc.close();

	}
}
