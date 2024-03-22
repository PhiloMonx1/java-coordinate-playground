package step05.model;

import java.util.List;

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

	abstract String areaInfo();
}
