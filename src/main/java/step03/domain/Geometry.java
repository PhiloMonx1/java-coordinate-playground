package step03.domain;

public abstract class Geometry {

	public static Geometry crate(String input) {
		String[] splitInput = input.split("-");

		if (splitInput.length == 2) {
			return new Line(new Point(splitInput[0]), new Point(splitInput[1]));
		}
		if (splitInput.length == 4) {
			return new Square(new Point(splitInput[0]), new Point(splitInput[1]),
					new Point(splitInput[2]), new Point(splitInput[3]));
		}
		throw new IllegalArgumentException("좌표가 잘못되었습니다.");
	}

	double length(Point start, Point end) {
		return Math.sqrt(Math.pow((start.getXposition() - end.getXposition()), 2) + Math.pow(
				(start.getYposition() - end.getYposition()), 2));
	}
}
