package step02.domain;

public class Point {

	private final Position x;
	private final Position y;

	public Point(Position x, Position y) {
		this.x = x;
		this.y = y;
	}

	public int getXposition() {
		return x.getPosition();
	}

	public int getYposition() {
		return y.getPosition();
	}
}
