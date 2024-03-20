package step04.domain;

public class Triangle extends Geometry {
	private final Point pointOne;
	private final Point pointTwo;
	private final Point pointThree;

	public Triangle(Point pointOne, Point pointTwo, Point pointThree) {
		this.pointOne = pointOne;
		this.pointTwo = pointTwo;
		this.pointThree = pointThree;
	}

	public double area() {
		double lineOne = super.length(pointOne, pointTwo);
		double lineTwo = super.length(pointTwo, pointThree);
		double lineThree = super.length(pointThree, pointOne);
		double s = (lineOne + lineTwo + lineThree) / 2;
		return Math.sqrt(s * (s - lineOne) * (s - lineTwo) * (s - lineThree));
	}
}
