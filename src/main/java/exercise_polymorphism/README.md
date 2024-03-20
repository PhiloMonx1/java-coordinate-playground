# 좌표계산기 실습 및 피드백

---

## 다형성 제거 실습

### 실습 환경 세팅
- java-coordinate-playground 저장소의 브랜치를 exercise-polymorphism 로 변경한다.
  - 작업 중인 코드가 있다면 add/commit 명령을 실행한다.
  - git checkout -t origin/exercise-polymorphism 명령을 실행한다.

### 프로그래밍 요구사항
- FigureFactory 클래스의 getInstance() 메소드를 보면 라인/삼각형/사각형을 구분하기 위해 if문을 사용하고 있다. if문 제거해 구현 가능하도록 한다.

### 힌트
- 다음 인터페이스를 활용해 구현한다.
```java
public interface FigureCreator {
    Figure create(List<Point> points);
}
```
- Map Collection을 활용한다.

## 좌표계산기 구현 코드 분석
- java-coordinate-playground 저장소의 브랜치를 javajigi 로 변경한다.
  - 작업 중인 코드가 있다면 `add/commit` 명령을 실행한다.
  - `git checkout -t origin/javajigi` 명령을 실행한다.
- 좌표계산기 구현 코드를 분석한다.