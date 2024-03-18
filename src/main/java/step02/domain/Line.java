package step02.domain;

public class Line {

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
		return Math.sqrt(Math.pow((start.getXposition() - end.getXposition()), 2) + Math.pow(
				(start.getYposition() - end.getYposition()), 2));
	}
}
