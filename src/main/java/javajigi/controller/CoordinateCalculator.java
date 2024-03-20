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
