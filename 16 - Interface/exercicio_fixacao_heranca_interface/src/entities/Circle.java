package entities;

import entities.enums.Color;

public class Circle extends AbstractShape {
	private Double raduis;

	public Circle(Color color, Double raduis) {
		super(color);
		this.raduis = raduis;
	}

	public Double getRaduis() {
		return raduis;
	}

	public void setRaduis(Double raduis) {
		this.raduis = raduis;
	}

	public double area() {

		return Math.PI * raduis * raduis;
	}

}
