/* Em um novo programa, inicie as seguintes variáveis
 * 		String product1 = "Cumputer";
		String product2 = "Office desk";
		
		int age = 30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.00;
		double price2 = 650.50;
		double measure = 53.234567;
 * */
/* Em seguida, usando os valores das variáveis, produz a seguinte saída na tela do console
 * Product
Cumputer, which price is $ 2100,00
Office desk, which price is $ 650,50
Record 30years old, code 5290 and gender F
Measure with eight decimal places: 53.234567
Rouded (three decimal places) : 53,235
Us decimal point: 53.235
 * */

package applicaption;

import java.util.Locale;


public class Program {

	public static void main(String[] args) {
		String product1 = "Cumputer";
		String product2 = "Office desk";
		
		int age = 30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.00;
		double price2 = 650.50;
		double measure = 53.234567;
		
		System.out.println("Product");
		System.out.printf(product1 +", which price is $ %.2f%n", price1);
		System.out.printf(product2 + ", which price is $ %.2f%n", price2);
		
		System.out.println("Record " + age + "years old, code " + code + " and gender " + gender);
	
		
		System.out.println("Measure with eight decimal places: " + measure);
		System.out.printf("Rouded (three decimal places): %.3f%n" , measure);
		
		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f%n", measure);
	}

}
