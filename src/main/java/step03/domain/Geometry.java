package step03.domain;

public abstract class Geometry {

	public static Geometry crate(String input) {
		if (input.split("-").length == 2) {
			return new Line(new Point(input.split("-")[0]), new Point(input.split("-")[1]));
		}
		if (input.split("-").length == 4) {
			return new Square(new Point(input.split("-")[0]), new Point(input.split("-")[1]),
					new Point(input.split("-")[2]), new Point(input.split("-")[3]));
		}
		throw new IllegalArgumentException("좌표가 잘못되었습니다.");
	}

	double length(Point start, Point end) {
		return Math.sqrt(Math.pow((start.getXposition() - end.getXposition()), 2) + Math.pow(
				(start.getYposition() - end.getYposition()), 2));
	}
}
