package step05.model;

import java.util.List;

public class Line extends Figure {

	private static final String OUTPUT_AREA_MESSAGE = "두 점 사이의 거리는 ";

	Line(List<Point> points) {
		super(points);
	}

	@Override
	FigureType getFigureType() {
		return FigureType.LINE;
	}

	@Override
	double area() {
		Point start = getPoints().get(0);
		Point end = getPoints().get(1);

		return start.calculateDistance(end);
	}

	@Override
	public String areaInfo() {
		return OUTPUT_AREA_MESSAGE + area();
	}
}
