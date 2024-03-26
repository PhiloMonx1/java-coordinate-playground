package step05.model;

import java.util.Objects;
import step05.utils.MathUtil;

public class Point {

	private final Coordinate x;
	private final Coordinate y;

	Point(int x, int y) {
		this(new Coordinate(x), new Coordinate(y));
	}

	private Point(Coordinate x, Coordinate y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x.getPosition();
	}

	int getY() {
		return y.getPosition();
	}

	public double calculateSlope(Point point) {
		if (getX() == point.getX()) {
			return Double.MAX_VALUE;
		}
		return Math.abs((double) (getY() - point.getY()) / (getX() - point.getX()));
	}

	public double calculateDistance(Point point) {
		return Math.sqrt(MathUtil.squareDifference(getX(), point.getX())
				+ MathUtil.squareDifference(getY(), point.getY()));
	}

	public boolean isSame(int x, int y) {
		return getX() == x && getY() == y;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point) o;
		return Objects.equals(x, point.x) && Objects.equals(y, point.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
