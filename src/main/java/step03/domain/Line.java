package step03.domain;

public class Line extends Geometry {
	private final Point start;
	private final Point end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Line(String line) {
		this(new Point(line.split("-")[0]), new Point(line.split("-")[1]));
	}

	public double length() {
		return super.length(start, end);
	}
}
