package step03.domain;

public abstract class Geometry {

	double length(Point start, Point end) {
		return Math.sqrt(Math.pow((start.getXposition() - end.getXposition()), 2) + Math.pow(
				(start.getYposition() - end.getYposition()), 2));
	}
}
