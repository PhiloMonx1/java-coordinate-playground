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

		Point[] organizedPoints = new Point[4];

		for (Point point : points) {
			if (point.getXposition() == minX && point.getYposition() == minY) {
				organizedPoints[0] = point;
			}
			if (point.getXposition() == maxX && point.getYposition() == minY) {
				organizedPoints[1] = point;
			}
			if (point.getXposition() == maxX && point.getYposition() == maxY) {
				organizedPoints[2] = point;
			}
			if (point.getXposition() == minX && point.getYposition() == maxY) {
				organizedPoints[3] = point;
			}
		}

		return Arrays.asList(organizedPoints);
	}
}
