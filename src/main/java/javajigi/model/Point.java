package javajigi.model;

import java.util.Objects;

public class Point {
    private static final String ERROR_OUT_OF_POINT_RANGE
            = "잘못된 범위의 입력값입니다. 정수 범위는 " + Point.LOWER_LIMIT + " ~ " + Point.UPPER_LIMIT + " 사이의 수로 입력해 주세요.";
    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkRangeOf(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkRangeOf(int x, int y) {
        if (exceedRange(x) || exceedRange(y)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_POINT_RANGE);
        }
    }

    private boolean exceedRange(int coordinate) {
        return coordinate < LOWER_LIMIT || coordinate > UPPER_LIMIT;
    }

    public double calculateSlope(Point point) { //*1
        if (this.x == point.x) {
            return Double.MAX_VALUE;
        }
        return Math.abs((double) (this.y - point.y) / (this.x - point.x));
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(squareDifference(this.x, point.x)
                + squareDifference(this.y, point.y));
    }

    private double squareDifference(int firstValue, int secondValue) {
        return Math.pow(firstValue - secondValue, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
/*
  _11 _Next : OutputView
  *1. Point와 또 다른 Point의 거리로 길이를 구하는 것처럼 기울기를 구하는 공식으로 선이 기울었는지도 구하고 있다.
      해당 함수는 Triangle에서 사용하고 있는데, 만약 평행한 기울기의 선이 2개 이상 있다면 삼각형이 구성될 수 없기 때문이다.
      또한 해당 함수는 Rectangle에서는 사용되지 않았는데, 회전된 직사각형을 인정하지 않기 때문에
      선의 기울기를 기반으로 직사각형 여부를 판단할 수 있었겠지만, 다른 구현 방식을 선택했다.
      (어떤 방식이 더 좋은지는 모르겠다.)
 */