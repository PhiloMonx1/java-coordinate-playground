package step05.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
	private static final String ERROR_INVALID_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
	private static final String ERROR_NOT_APPLY_CLASSIFIER = "지원하지 않는 도형입니다.";
	private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

	static {
		classifier.put(FigureType.LINE.getVertices(), Line::new);
		classifier.put(FigureType.TRIANGLE.getVertices(), Triangle::new);
		classifier.put(FigureType.RECTANGLE.getVertices(), Rectangle::new);
	}

	private FigureFactory() {
		throw new IllegalStateException(this.getClass().getSimpleName() + "는 유틸리티 클래스입니다.");
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
		try {
			return classifier.get(points.size()).apply(points);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		} catch (NullPointerException e){
			throw new NullPointerException(ERROR_NOT_APPLY_CLASSIFIER);
		}
	}
}
