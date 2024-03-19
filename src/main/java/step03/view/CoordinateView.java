package step03.view;

import step03.domain.Geometry;
import step03.domain.Line;
import step03.domain.Square;

public class CoordinateView {

	private static final String REPORT_LINE_LENGTH = "두 점 사이 거리는 ";
	private static final String REPORT_SQUARE_AREA = "사각형 넓이는 ";

	public void printResult(Geometry geometry) {
		if (geometry instanceof Line) {
			Line line = (Line) geometry;
			System.out.println(REPORT_LINE_LENGTH + line.length());
		}
		if (geometry instanceof Square) {
			Square square = (Square) geometry;
			System.out.println(REPORT_SQUARE_AREA + square.area());
		}
	}
}
