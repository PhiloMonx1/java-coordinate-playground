package step05.view;

import step05.model.Coordinate;
import step05.model.Figure;

public class OutputView {

	private static final String FOUR_BLANK = "    ";
	private static final String VERTICAL_AXIS = "|";
	private static final String ORIGIN = "+";
	private static final String HORIZONTAL_AXIS = "----";
	private static final String MARK_OF_POINT = "●";

	private OutputView() {
		throw new IllegalStateException(this.getClass().getSimpleName() + "는 유틸리티 클래스입니다.");
	}

	public static void showCoordinate(Figure figure) {
		showCoordinatePlane(figure);
		showArea(figure);
	}

	private static void showCoordinatePlane(Figure figure) {
		showVerticalNumbersWith(figure);
		showHorizontalAxis();
		showHorizontalNumbers();
	}

	private static void showVerticalNumbersWith(Figure figure) {
		for (int y = Coordinate.UPPER_LIMIT; y >= Coordinate.LOWER_LIMIT; y--) {
			showAxisNumber(y);
			System.out.print(VERTICAL_AXIS);
			showPoints(figure, y);
			emptyLine();
		}
	}

	private static void showAxisNumber(int index) {
		if (index % 2 == 0) {
			System.out.printf("%4d", index);
			return;
		}
		System.out.print(FOUR_BLANK);
	}

	private static void showPoints(Figure figure, int y) {
		for (int x = Coordinate.LOWER_LIMIT; x <= Coordinate.UPPER_LIMIT; x++) {
			if (figure.hasPoint(x, y)) {
				System.out.printf("%4s", MARK_OF_POINT);
				continue;
			}
			System.out.print(FOUR_BLANK);
		}
	}

	private static void showHorizontalAxis() {
		System.out.print(FOUR_BLANK + ORIGIN);
		for (int x = Coordinate.LOWER_LIMIT; x <= Coordinate.UPPER_LIMIT; x++) {
			System.out.print(HORIZONTAL_AXIS);
		}
		emptyLine();
	}

	private static void showHorizontalNumbers() {
		for (int x = 0; x <= Coordinate.UPPER_LIMIT; x++) {
			showAxisNumber(x);
		}
		emptyLine();
	}

	private static void emptyLine() {
		System.out.println();
	}

	private static void showArea(Figure figure) {
		System.out.println(figure.areaInfo());
	}
}