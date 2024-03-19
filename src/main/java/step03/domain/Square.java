package step03.domain;

public class Square {
	private final Line width;
	private final Line height;
	public Square(Point pointSW, Point pointSE, Point pointNE, Point pointNW) {
		this.width = new Line(pointSW, pointSE);
		this.height = new Line(pointSE, pointNE);
	}

	public double area() {
		return width.length() * height.length();
	}
}
