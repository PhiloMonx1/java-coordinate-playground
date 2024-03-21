package javajigi.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    static final String ERROR_FIGURE_NULL = "올바른 Point 값이 아닙니다.";
    private final List<Point> points;

    AbstractFigure(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(ERROR_FIGURE_NULL);
        }
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean hasPoint(int x, int y) {
        return getPoints().stream()
                .anyMatch(point -> point.isSame(x, y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
/*
  _06 _Next : Line
  Figure 추상클래스이다. Figure 인터페이스를 상속하고 있다. Line, Triangle, Rectangle 등의 구현체가 해당 추상클래스를 상속한다.
  주석 번호는 6번이지만, 사실상 생성 순서는 더 앞선다고 할 수 있다. Figure 인터페이스가 1번, 해당 추상 클래스가 2번일 수 있다.

  신기한 점은 Figure 인터페이스의 getPoints(), hasPoint() 메서드는 구현을 했는데,
  area()와 getAreaInfo()는 구현하지 않았다는 점이다. 인터페이스의 추상 메서드는 반드시 구현을 해야 하는 걸로 알고 있는데,
  해당 패턴이 이해가 되지 않는다.

  또한 기본적으로 List<Point> points 를 가지고 있기 때문에, 하위 클래스에서는 몇개의 point를 가지고 있을지에 대한 인스턴스 필드가 필요가 없는 것 같다.
  마찬가지로 추상 클래스에서 구체적으로 구현한 메서드의 경우 하위 클래스에서 별도로 선언하지 않는 것을 볼 수 있었다.

  추상 클래스가 인터페이스를 상속하는 것은 인상 깊었다. 나는 추상클래스와 인터페이스를 상위 클래스라는 개념으로 이해하고 있었다.
  아직 상속 관계를 어떻게 설정하는 것이 맞는지 그 설계를 더 많은 케이스를 통해 배워야겠다는 생각이 들었다.

  그리고 의문이 드는게 있다. 왜 Figure 인터페이스를 만들었을까? 그냥 AbstractFigure만 가지고 할 수는 없었을까?
  추상 클래스 역시 추상 메서드를 선언할 수 있다. 그렇다면 getPoints(), hasPoint()의 경우 구현하고,
  area()와 getAreaInfo()는 추상 메서드로 선언해서 구현할 수도 있지 않았을까?
  접근 제한자와 관계가 있는건지 아니면 교육을 위한 구현인건지 아직은 파악이 되지 않는다.
 */