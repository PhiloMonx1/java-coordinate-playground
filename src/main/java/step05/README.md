# 좌표계산기 재구현

---

## 기능 요구사항
- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
- X, Y좌표 모두 최대 24까지만 입력할 수 있다.
- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.
- 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
    - 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
    - 사각형인 경우 사각형의 넓이를 계산해서 출력한다.
-  좌표값을 세 개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.
  - 삼각형인 경우 삼각형의 넓이를 계산해서 출력한다.

## 구현 일지
1. Point 클래스 구현.
> 피드백 코드를 볼 때는 모든 것이 다 이해되고, 설계도 바로 할 수 있을 것 같았으나, 쉽지 않았다.<br>
> 오랫동안 코드를 한 줄도 적지 못하는 상황이었기 때문에 완벽하게 구현하고자 하는 욕심을 버리고,<br>
> 우선 피드백 코드를 본 후에 확장된 시야를 토대로 재구현을 하기로 했다.<br>
> 그게 아니라면 계속해서 피드백 코드를 보게 될 것이고, 그냥 따라 적는 것과 크게 다르지 않을 것이라 생각했기 때문이다.<br>
> 우선적으로 Point 클래스를 구현할 것인데,피드백 강의에서 구현한 모든 것을 구현하지 않고, 요구사항을 충족하는 데 집중할 것이다.

2. Figure 추상 클래스 구현
> Figure 인터페이스 없이 `AbstractFigure` 추상 클래스만으로도 구현을 할 수 있지 않을까?<br>
> 피드백 코드에선 `InputView::checkAccuracyOfPoints` 에서 정규식을 통해 Point 배열의 최대 값을 검증하고 있다.<br>
> 그러나 만약 오각형, 육각형이 생겨나게 되면 해당 코드가 바뀌어야 한다. 그렇기에 나는 `FigureFactory` 클래스에 선언된 <br>
> `NUM_OF_VERTICES_OF_` 상수를 활용해서, 상수 중 가장 큰 값을 `InputView::checkAccuracyOfPoints` 에서 가지는 방법을 고민하고자 한다. <br>
> 또한 `FigureFactory`의 `NUM_OF_VERTICES_OF_` 상수 또한 각 도형 클래스에서 가져와서 선언하는 것을 변경하고자 한다.

3. Line 클래스 구현
> `NUM_OF_VERTICES` 상수를 구현하는 부분에서 문제가 생겼다. 
```java
package step05.model;

import java.util.List;

public class Line extends Figure {
	private static final int NUM_OF_VERTICES = 2;
	private static final String OUTPUT_AREA_MESSAGE = "두 점 사이의 거리는 "; //*1

	Line(List<Point> points) {
		super(points);
	}

	@Override
	int getVertexNumber() {
		return NUM_OF_VERTICES;
	}
	
	// 생략...
}
```
> `getVertexNumber()` 메서드를 어떻게 선언하는게 좋을까? FigureFactory에서 사용하기 위해서는 static으로 선언해야 한다.<br>
> 하지만 추상 메서드는 static으로 선언할 수 없다. (부모 클래스가 초기화 되지 않은 상태에서 부모 클래스의 추상 메서드를 가져올 수 없기 때문)<br>
> 물론 `NUM_OF_VERTICES` 상수를 public static 으로 선언하는 것으로도 해결 할 수 있었지만, 나는 `NUM_OF_VERTICES` 상수를 강제하고 싶었다.<br>
> 즉, `Figure`를 상속하는 새로운 클래스가 구현될 때, 반드시 `NUM_OF_VERTICES` 상수를 함께 선언해야 하는데 이것을 강제하는 방법이 없었다.
>
> 고민을 하며 이것저것 찾아보다가 `Enum`을 활용하기로 했다. <br>
> 문자열 계산기를 피드백 강의를 볼 때, `Enum`을 활용해서 연산자를 지정하고, 계산까지 하는 방식을 엿보았다. <br>
> 내 아이디어는 다음과 같다. 본래 `getVertexNumber()`의 목적은 하위 클래스로 하여금 `VertexNumber`를 가지게 만들기 위함이었다 <br>
> 그러나 팩토리 메소드에서 사용하기 위해선 static으로 선언해야 한다는게 내가 겪고 있는 문제점이다. <br>
> 그렇다면 `getVertexNumber()` 대신에 `abstract FigureType getFigureType();` 을 구현하도록 만들면 어떨까?

<details>
<summary>아래의 코드가 된다.</summary>

```java
package step05.model;

public enum FigureType {
LINE(2)
;

private final int vertices;
FigureType(int vertices) {
this.vertices = vertices;
}

public int getVertices() {
return vertices;
}
}
```
> `Enum`을 통해 `vertices` 값을 설정해 줄 수 있다. 이렇게 되면
```java
public class FigureFactory {

	//...생략
	private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>(); // *1

	static {
		classifier.put(FigureType.LINE.getVertices(), Line::new);
	}
	//...생략
}
```
> 팩토리 메서드는 이렇게 된다. 팩토리 클래스에서 직접 상수를 넣는 것보다는 나아보인다.
```java
public class Line extends Figure {

  //...생략
	@Override
	FigureType getFigureType() {
		return FigureType.LINE;
	}

  //...생략
}
```
> 또한 `Figure`를 상속하는 하위 클래스에서는 `getFigureType()`를 반드시 구현하도록 만들어 신규 클래스가 생겼을 때 FigureType 내에 함께 선언해줘야 함을 암시할 수 있다. <br>
> 물론 단순한 아이디어일 뿐 그렇게 나아졌다고 볼 수는 없다. 결과적으로 `getFigureType()` 메서드의 활용도가 떨어진다면 메모리 낭비일 수도 있으니 말이다. <br>
</details>

4. Rectangle & Triangle 구현

> 한 번 구현을 했던 문제지만 예외 처리를 해야 했기에 막막했다. 그러나 이번 챕터의 목표는 기하학적 계산 능력이 아니고, 상속을 통한 객체지향설계이다. <br>
> 그렇기에 부담감을 내려놓고, 학습 목표에 집중하기로 했다. 내가 집중해야 할 것은 각 클래스의 역할, 의존도, 결합도, 접근 제한 등이다.