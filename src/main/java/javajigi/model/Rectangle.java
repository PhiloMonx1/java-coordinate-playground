package javajigi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class Rectangle extends AbstractFigure {
    private static final String ERROR_INVALID_RECTANGLE = "직사각형 모양이 아닙니다.";
    private static final String OUTPUT_AREA_OF_RECTANGLE = "사각형의 넓이는 ";
    private static final int NUM_OF_TYPES_OF_RECTANGLE_COORDINATES = 2;

    Rectangle(List<Point> points) {
        super(points);
        checkRectangleWith(points); //*1
    }

    private void checkRectangleWith(List<Point> points) {
        Set<Integer> xValuesOfPoints = convertToUniqueXValues(points);
        Set<Integer> yValuesOfPoints = convertToUniqueYValues(points);

        if (hasNotTwoPoints(xValuesOfPoints) || hasNotTwoPoints(yValuesOfPoints)) {
            throw new IllegalArgumentException(ERROR_INVALID_RECTANGLE);
        }
    }

    private Set<Integer> convertToUniqueXValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getX);
    }

    private Set<Integer> convertToUniqueYValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getY);
    }

    private Set<Integer> convertToUniqueValues(List<Point> points, Function<Point, Integer> function) {
        return points.stream()
                .map(function)
                .collect(toSet());
    }

    private boolean hasNotTwoPoints(Set<Integer> valuesOfPoints) {
        return valuesOfPoints.size() != NUM_OF_TYPES_OF_RECTANGLE_COORDINATES; // *2
    }

    @Override
    public double area() {
        List<Point> points = getPoints();
        int differenceOfXValues = calculateDifference(convertToUniqueXValues(points));
        int differenceOfYValues = calculateDifference(convertToUniqueYValues(points));

        return (double) (differenceOfXValues * differenceOfYValues);
    }

    private int calculateDifference(Set<Integer> valuesOfPoints) {
        List<Integer> values = new ArrayList<>(valuesOfPoints);
        return Math.abs(values.get(0) - values.get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_RECTANGLE + area();
    }
}
/*
  _09 _Next : Triangle
  *1. 이와 같이 별도의 로직을 더 수행하도록 할 수 있다. points의 검증의 경우 모든 클래스가 공유하는 로직이지만,
      내가 이전 스탭에서 고민했던 대각선 변 등의 예외처리는 Rectangle에서만 수행하기에 구현 클래스 내부에서 수행한다.

  *2. 내 입장에서는 로직을 이해하는데 시간이 걸렸는데, 아이디어는 다음과 같다.
      직사각형은 두개의 동일한 X 좌표와, Y 좌표로 이루어져 있다. ex) `(10,15)-(22,15)-(22,18)-(10,18)`
      그래서 set을 통해 x와 y 좌표를 취합해서 그 길이가 2인지를 검증하는 것이다.
      그러나 해당 구현은 회전된 직사각형 즉, 좌표축에 평행하지 직사각형을 직사각형으로 인정하지 않게된다.
      (1~24 좌표 내에서 회전된 직사각형이 존재할 수 있는지는 아직 모른다.)
 */