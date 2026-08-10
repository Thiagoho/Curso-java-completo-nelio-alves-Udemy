package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order { // ordem
private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment; // moment
	private OrderStatus  status;
	
	
	// Estamos criando a associação 1 Cleinte  items *
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>(); // new ArrayList<>() distanciando items na class.
	
	public Order () {}
	public Order(Date moment, OrderStatus status, Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
// Aqui não add get items para segurança da minha itens encapsulei ele.
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removerItem(OrderItem item) {
		items.remove(item);
	}
	public double total() {
		double sum = 0; 
		for (OrderItem it: items) { // delegação de responsabilidade 'soma do orderItem'.
			sum += it.subTotal();
		}
		// OrderItem calcular o product 
		return sum;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (OrderItem item: items) {
				sb.append(item + "\n");
				}
	sb.append("Total price: $");
	sb.append(String.format("%.2f", total()));
	return sb.toString();
	}
}
