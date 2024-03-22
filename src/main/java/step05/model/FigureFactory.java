package step05.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
	private static final String ERROR_INVALID_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
	private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

	static {
		classifier.put(FigureType.LINE.getVertices(), Line::new);
		classifier.put(FigureType.TRIANGLE.getVertices(), Triangle::new);
		classifier.put(FigureType.RECTANGLE.getVertices(), Rectangle::new);
	}


	public static Figure create(List<Point> points) {
		if (points == null) {
			throw new IllegalArgumentException(Figure.ERROR_POINTS_NULL);
		}
		if (isInvalidNumberOf(points)) {
			throw new IllegalArgumentException(ERROR_INVALID_FIGURE_CREATION);
		}
		return classifyFigure(points);
	}

	private static boolean isInvalidNumberOf(List<Point> points) {
		int numOfPoints = points.size();
		return numOfPoints < FigureType.getMinVertices() || numOfPoints > FigureType.getMaxVertices();
	}

	private static Figure classifyFigure(List<Point> points) {
		return classifier.get(points.size()).apply(points);
	}
}
