package step05.model;

import step05.utils.MathUtil;

public class Point {

	private final Coordinate x;
	private final Coordinate y;

	public Point(Coordinate x, Coordinate y) {
		this.x = x;
		this.y = y;
	}

	private int getX() {
		return x.getPosition();
	}

	private int getY() {
		return y.getPosition();
	}

	public double calculateDistance(Point point) {
		return Math.sqrt(MathUtil.squareDifference(getX(), point.getX())
				+ MathUtil.squareDifference(getY(), point.getY()));
	}
}
