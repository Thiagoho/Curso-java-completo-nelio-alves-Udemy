package entities;
public class ImportedProduct extends Product{ // Produto importado
	private Double customsFee; // taxas alfandega
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price); // repassa nome e preço para á class mae (Product)
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName()
				+ "- $" 
				+ String.format("%.2f", totalPrice())
				+ "(Customs free: $ )"
				+ String.format("%.2f", customsFee);
	}
	// Esse metodos somando valor + taxa da alfandega
	public double totalPrice() {
		return getPrice() + customsFee;
	}
}
