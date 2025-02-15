package step04.view;

import step04.domain.Line;
import step04.domain.Geometry;
import step04.domain.Square;
import step04.domain.Triangle;

public class CoordinateView {

	private static final String REPORT_LINE_LENGTH = "두 점 사이 거리는 ";
	private static final String REPORT_SQUARE_AREA = "사각형 넓이는 ";
	private static final String REPORT_TRIANGLE_AREA = "삼각형 넓이는 ";

	public void printResult(Geometry geometry) {
		if (geometry instanceof Line) {
			Line line = (Line) geometry;
			System.out.println(REPORT_LINE_LENGTH + line.length());
		}
		if (geometry instanceof Triangle) {
			Triangle triangle = (Triangle) geometry;
			System.out.println(REPORT_TRIANGLE_AREA + triangle.area());
		}
		if (geometry instanceof Square) {
			Square square = (Square) geometry;
			System.out.println(REPORT_SQUARE_AREA + square.area());
		}
	}
}
