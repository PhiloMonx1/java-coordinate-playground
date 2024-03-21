package javajigi.model;

import java.util.List;

public class Triangle extends AbstractFigure {
    private static final String ERROR_INVALID_TRIANGLE = "삼각형 모양이 아닙니다.";
    private static final String OUTPUT_AREA_OF_TRIANGLE = "삼각형의 넓이는 ";

    Triangle(List<Point> points) {
        super(points);
        if (isInStraightLine(points)) {
            throw new IllegalArgumentException(ERROR_INVALID_TRIANGLE);
        }
    }

    private boolean isInStraightLine(List<Point> points) { //*1
        return points.get(0).calculateSlope(points.get(1)) == points.get(0).calculateSlope(points.get(2));
    }

    @Override
    public double area() { //*1
        Point firstPoint = getPoints().get(0);
        Point secondPoint = getPoints().get(1);
        Point thirdPoint = getPoints().get(2);

        double firstSide = firstPoint.calculateDistance(secondPoint);
        double secondSide = secondPoint.calculateDistance(thirdPoint);
        double thirdSide = thirdPoint.calculateDistance(firstPoint);

        return calculateFormulaOfHero(firstSide, secondSide, thirdSide);
    }

    private double calculateFormulaOfHero(double firstSide, double secondSide, double thirdSide) {
        double s = (firstSide + secondSide + thirdSide) / 2;

        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_TRIANGLE + area();
    }
}
/*
  _10 _Next : Point
  *1. 요구사항의 도형들은 요구사항을 충족하기 공통적으로 선의 길이를 가지고 있어야 했다.
      여기서는 선의 길이를 구하는 로직을 Line이 아닌 Point에서 구현했다.
      A Point를 기점으로 B 포인트까지의 거리를 계산하면 선의 길이가 되기 때문이다.
 */