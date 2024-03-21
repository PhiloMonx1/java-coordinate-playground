package javajigi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final String ERROR_INVALID_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
    private static final int NUM_OF_VERTICES_OF_LINE = 2;
    private static final int NUM_OF_VERTICES_OF_TRIANGLE = 3;
    private static final int NUM_OF_VERTICES_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>(); // *1

    static {
        classifier.put(NUM_OF_VERTICES_OF_LINE, Line::new);
        classifier.put(NUM_OF_VERTICES_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_VERTICES_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure create(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(AbstractFigure.ERROR_FIGURE_NULL);
        }
        if (isInvalidNumberOf(points)) {
            throw new IllegalArgumentException(ERROR_INVALID_FIGURE_CREATION);
        }
        return classifyFigure(points);
    }

    private static boolean isInvalidNumberOf(List<Point> points) {
        int numOfPoints = points.size();
        return numOfPoints < NUM_OF_VERTICES_OF_LINE || numOfPoints > NUM_OF_VERTICES_OF_RECTANGLE;
    }

    private static Figure classifyFigure(List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}

/*
  _04 _Next : Figure
  단 하나의 public 메서드를 가지며, Figure 객체를 생성하는 메서드이다.
  *1. 이번 챕터의 핵심으로 볼 수 있다. create() 메서드에서 classifier 내부에 들어있는 하위 클래스를 가져와서 리턴하는
      classifyFigure() 메서드를 사용하고 있기 때문이다.
      - Map에 value로 들어간 `Function<List<Point>, Figure>` 부분이 생소한데, `자바 Function<T, R>` 인터페이스 함수이다.
      - `Line::new` 역시 생소한데, `Constructor Reference (생성자 참조)` 이다.

      classifier.put(NUM_OF_VERTICES_OF_LINE, Line::new); 의 경우 NUM_OF_VERTICES_OF_LINE의 값은 2이고 Line 생성자를 값으로 가진다.
      즉 points.size()의 사이즈가 2라면 Key 값이 2인 Value Line::new가 리턴되게 된다.
 */