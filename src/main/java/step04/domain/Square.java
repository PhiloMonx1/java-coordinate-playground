package step04.domain;

import java.util.Arrays;
import java.util.List;

public class Square extends Geometry {

	private final Point pointSW;
	private final Point pointSE;
	private final Point pointNE;
	private final Point pointNW;

	public Square(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
		this(Arrays.asList(pointOne, pointTwo, pointThree, pointFour));
	}

	private Square(List<Point> points) {
		points = placeAllPoints(points);
		this.pointSW = points.get(0);
		this.pointSE = points.get(1);
		this.pointNE = points.get(2);
		this.pointNW = points.get(3);
	}

	public double area() {
		double width = super.length(pointSW, pointSE);
		double height = super.length(pointSE, pointNE);
		return width * height;
	}

	private List<Point> placeAllPoints(List<Point> points) {
		int minX = points.stream().mapToInt(Point::getXposition).min().getAsInt();
		int minY = points.stream().mapToInt(Point::getYposition).min().getAsInt();
		int maxX = points.stream().mapToInt(Point::getXposition).max().getAsInt();
		int maxY = points.stream().mapToInt(Point::getYposition).max().getAsInt();

		Point pointSW = new Point(new Position(minX), new Position(minY));
		Point pointSE = new Point(new Position(maxX), new Position(minY));
		Point pointNE = new Point(new Position(maxX), new Position(maxY));
		Point pointNW = new Point(new Position(minX), new Position(maxY));

		return Arrays.asList(pointSW, pointSE, pointNE, pointNW);
	}
}
