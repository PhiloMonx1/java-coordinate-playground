package javajigi.view;

import javajigi.model.Figure;
import javajigi.model.Point;

public class OutputView {
    private static final String FOUR_BLANK = "    ";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "----";
    private static final String MARK_OF_POINT = ".";

    public static void showCoordinatePlane(Figure figure) {
        showVerticalNumbersWith(figure);
        showHorizontalAxis();
        showHorizontalNumbers();
    }

    private static void showVerticalNumbersWith(Figure figure) {
        for (int y = Point.UPPER_LIMIT; y >= Point.LOWER_LIMIT; y--) {
            showAxisNumber(y);
            System.out.print(VERTICAL_AXIS);
            showPoints(figure, y);
            emptyLine();
        }
    }

    private static void showAxisNumber(int index) {
        if (index % 2 == 0) {
            System.out.print(String.format("%4d", index));
            return;
        }
        System.out.print(FOUR_BLANK);
    }

    private static void showPoints(Figure figure, int y) {
        for (int x = Point.LOWER_LIMIT; x <= Point.UPPER_LIMIT; x++) {
            if (figure.hasPoint(x, y)) {
                System.out.print(String.format("%4s", MARK_OF_POINT));
                continue;
            }
            System.out.print(FOUR_BLANK);
        }
    }

    private static void showHorizontalAxis() {
        System.out.print(FOUR_BLANK + ORIGIN);
        for (int x = Point.LOWER_LIMIT; x <= Point.UPPER_LIMIT; x++) {
            System.out.print(HORIZONTAL_AXIS);
        }
        emptyLine();
    }

    private static void showHorizontalNumbers() {
        for (int x = 0; x <= Point.UPPER_LIMIT; x++) {
            showAxisNumber(x);
        }
        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void showArea(Figure figure) {
        System.out.println(figure.getAreaInfo());
    }
}
/*
  _12 _End
  아웃풋 view를 담당하고 있으며 showCoordinatePlane()와 showArea() 메서드를 제외하고는 전부 private이다.
  public 메서드는 CoordinateCalculator의 run()에서 사용하고 있는데,
  왜 showArea()를 showCoordinatePlane() 내부에 통합시키지 않았는지는 잘 모르겠다.
  메서드의 단일 책임을 위한 것일까?
  그렇다면 showCoordinatePlane()와 showArea()를 통합하는 또 다른 메서드를 만드는 것은 어떨까?
 */