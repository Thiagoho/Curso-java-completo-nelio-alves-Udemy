package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	private LocalDate manufactureDate; // dados Fabricados
	
	public UsedProduct() {
		super();
		
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price); //repassa nome e preço para à class mãe (Product)
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	// Método que junto os textos para criar a etiqueta de produto usado
	@Override
	public String priceTag() {
		// formata a data para o padrão brasileiro(DD/MM/AAAA)
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return getName() 
				+ "(used) $"
				+ String.format("%.2f", getPrice())
				+ "Manufacture date: "
				+ manufactureDate.format(dtf) 
				+ ")";
	}
	
}
