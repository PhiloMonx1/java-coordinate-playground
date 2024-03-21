package javajigi.controller;

import javajigi.model.Figure;
import javajigi.view.InputView;
import javajigi.view.OutputView;

public class CoordinateCalculator {
    public void run() {
        Figure figure = InputView.inputCoordinates();
        OutputView.showCoordinatePlane(figure);
        OutputView.showArea(figure);
    }
}
/*
  _02 _Next : InputView
  CoordinateCalculator의 위치는 controller 패키지이며,
  run() 메서드는 3가지 동작을 한다.
  1. Figure 인스턴스를 생성한다. (의존성 주입)
  2. 좌표 필드 및 사용자 입력 좌표의 Point를 노출시킨다.
  3. 좌표에 의해 생성된 도형의 길이나 면적, Area를 노출시킨다.
 */