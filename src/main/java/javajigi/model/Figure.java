package javajigi.model;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    boolean hasPoint(int x, int y);

    double area();

    String getAreaInfo();
}
/*
  _05 _Next : AbstractFigure
  Figure 인터페이스이다.
 */