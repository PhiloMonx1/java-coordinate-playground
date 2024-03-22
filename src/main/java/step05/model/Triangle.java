package step05.model;

import java.util.List;
import step05.utils.MathUtil;

public class Triangle extends Figure {

	private static final String ERROR_INVALID_TRIANGLE = "삼각형 모양이 아닙니다.";
	private static final String OUTPUT_AREA_MESSAGE = "삼각형의 넓이는 ";

	Triangle(List<Point> points) {
		super(points);
		isInStraightLine(points);
	}

	private void isInStraightLine(List<Point> points) {
		if (points.get(0).calculateSlope(points.get(1)) == points.get(0)
				.calculateSlope(points.get(2))) {
			throw new IllegalArgumentException(ERROR_INVALID_TRIANGLE);
		}
	}

	@Override
	FigureType getFigureType() {
		return FigureType.TRIANGLE;
	}

	@Override
	double area() {
		Point firstPoint = getPoints().get(0);
		Point secondPoint = getPoints().get(1);
		Point thirdPoint = getPoints().get(2);

		double firstSide = firstPoint.calculateDistance(secondPoint);
		double secondSide = secondPoint.calculateDistance(thirdPoint);
		double thirdSide = thirdPoint.calculateDistance(firstPoint);

		return MathUtil.calculateFormulaOfHeron(firstSide, secondSide, thirdSide);
	}


	@Override
	String areaInfo() {
		return OUTPUT_AREA_MESSAGE + area();
	}
}
