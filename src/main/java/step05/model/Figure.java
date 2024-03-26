package step05.model;

import java.util.List;
import java.util.Objects;

public abstract class Figure {

	static final String ERROR_POINTS_NULL = "좌표는 빈 값일 수 없습니다.";
	private final List<Point> points;

	Figure(List<Point> points) {
		if (points == null || points.isEmpty()) {
			throw new IllegalArgumentException(ERROR_POINTS_NULL);
		}
		this.points = points;
	}

	List<Point> getPoints() {
		return points;
	}

	abstract FigureType getFigureType();

	abstract double area();

	public abstract String areaInfo();

	public boolean hasPoint(int x, int y) {
		return getPoints().stream()
				.anyMatch(point -> point.isSame(x, y));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Figure figure = (Figure) o;
		return Objects.equals(points, figure.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}