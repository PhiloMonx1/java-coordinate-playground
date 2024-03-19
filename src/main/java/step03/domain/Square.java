package step03.domain;

public class Square extends Geometry {

	private final Point pointSW;
	private final Point pointSE;
	private final Point pointNE;
	private final Point pointNW;

	public Square(Point pointSW, Point pointSE, Point pointNE, Point pointNW) {
		this.pointSW = pointSW;
		this.pointSE = pointSE;
		this.pointNE = pointNE;
		this.pointNW = pointNW;
	}

	public Square(String input) {
		this(new Point(input.split("-")[0]), new Point(input.split("-")[1]),
				new Point(input.split("-")[2]), new Point(input.split("-")[3]));
	}

	public double area() {
		double width = super.length(pointSW, pointSE);
		double height = super.length(pointSE, pointNE);
		return width * height;
	}
}
