package application;

import java.io.IO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	void main() {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		List<Shape> list = new ArrayList<>();

		IO.print("Enter the number of shapes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			IO.println("Shepe #" + i + " data");
			IO.print("Rectangle or Circle (r/c)? ");
			char ch = sc.next().charAt(0);
			IO.print("Color (BLACK/BLUE/RED): ");
			sc.nextLine();

			// Estamos declarando uma variavél do tipo color, recebendo 'Color'
			// vaLueof(sc.next)-> estamo convertendo.
			Color color = Color.valueOf(sc.next());
			if (ch == 'r') {
				IO.print("Width: ");
				double width = sc.nextDouble();
				IO.print("heigth: ");
				double height = sc.nextDouble();
				list.add(new Rectangle(color, width, height));
			} else {
				IO.print("Radius: ");
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius));

			}

		}
		IO.println();
		IO.println("SHAPE AREAS.");
		for (Shape shape : list) {
			IO.println(String.format("%.2f", shape.area()));
		}

		sc.close();
	}
}
