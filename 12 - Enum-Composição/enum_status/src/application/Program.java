package application;

import java.util.Date;

import entities.Order;
import entities_enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Order order = new Order(1080, new Date(), OrderStatus.PRONDING_PAYMENT);
		System.out.println(order);
		
		
		// Conversão de String para enum
		OrderStatus os1 = OrderStatus.DELIVERED; //SIMPLES  Você o da class OrderStatus nome especifico seria 'DELIVERED'
		System.out.println(os1);
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");// PODE USAR OrderStatus.vaLueof("");
		System.out.println(os2);

	}

}
