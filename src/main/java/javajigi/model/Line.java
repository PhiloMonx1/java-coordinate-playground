package javajigi.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String OUTPUT_AREA_OF_LINE = "두 점 사이의 거리는 "; //*1

    Line(List<Point> points) { //*2
        super(points);
    }

    @Override
    public double area() { //*3
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_LINE + area();
    }
}
/*
  _07 _Next : Rectangle
  *1. 내가 View 클래스를 따로 생성 해 관리했던 OUTPUT 상수를 내부에서 가지고 있다.
      이렇게 되면 OutputView의 경우 어떤 클래스인지 확인할 필요가 없을 것이다.

  *2. 기본 생성자를 선언하지 않으면 public으로 초기화된다. 때문에 패키지 내에서만 접근 가능한 Default 생성자를 선언했다.
      Line과 같은 패키지에 속한 FigureFactory의 경우 Line의 생성자를 호출할 수 있지만, Main이나 controller, view의 경우
      직접 호출하는 것이 불가하며 반드시 FigureFactory를 통해 Line을 생성해야 한다. 패키지의 분리 역시 접근에 큰 영향을 준다.
      단순히 팩토리 메서드를 만들었다고 해서 되는 것이 아니라, 외부에서 팩토리 메서드 만을 사용해서 생성할 수 있어야. 의미가 있다.
      내부에서 super의 생성자를 호출하는 것도 인상 깊었다. AbstractFigure에만 points를 선언한 이유를 알 수 있었다.
      다만, 이렇게 AbstractFigure의 생성자를 호출했는데도, 어떻게 Line 일 수 있을까?
      AbstractFigure를 호출하는 것이 곧 AbstractFigure 생성자를 리턴하는 것은 아니다. (리턴이라는 표현이 어색할 수는 있다.)
      실제로 생성자의 생성 주체는 `Line` 이라는 이름으로 결정된다. 그렇다면 내부에서 수행하는 `super(points);`는 어떤 역할을 하는가?
      중요한 점은 `new super(points);` 가 아니라는 점이다. 앞선 경우는 생성자를 생성하는 것이 되지만 현재의 경우에는
      생성자 생성이 아닌, 초기화를 수행하게 된다.
      !!단순하게 AbstractFigure의 생성자가 수행하는 로직(밸리데이션 & points 변수 할당)을 Line 역시 수행한다고 생각하면 된다.

  *3. 선의 길이는 면적이라고 말하지 않는다. 이 때문에 area()와 length()를 구분하려고 했고, 인터페이스를 사용하는 데 어려움을 겪기도 했다.
      그냥 area()라고 해도 되는걸까. 애초에 Line이 Figure가 맞는가? 알아보니 맞다.(기하학에서 선은 가장 기본적인 도형이라고 한다.)
      그러나 선은 면적을 가질 수 없기는하다. 이것을 프로그래밍적 허용이라고 불러야 할까? 이로 인해 누군가는 헷갈릴 수도 있지 않을까?
 */