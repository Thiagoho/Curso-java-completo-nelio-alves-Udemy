package entities;

public class Product { // Produto
	private  String name; // nome
	private Double price; // valor
	
	public Product() {}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Método mostrar na tela nome e valor do product
	public String priceTag() {
		return name + " - $" + String.format("%.2f ", price);
	}

}
