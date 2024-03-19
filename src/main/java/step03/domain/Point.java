package step03.domain;

public class Point {

	private final Position x;
	private final Position y;

	public Point(Position x, Position y) {
		this.x = x;
		this.y = y;
	}

	public Point(String point) {
		this(new Position(point.split(",")[0]), new Position(point.split(",")[1]));
	}

	public int getXposition() {
		return x.getPosition();
	}

	public int getYposition() {
		return y.getPosition();
	}
}
