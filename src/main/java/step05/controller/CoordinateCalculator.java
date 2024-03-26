package step05.controller;

import java.util.List;
import step05.model.Figure;
import step05.model.FigureFactory;
import step05.model.Point;
import step05.model.PointFactory;
import step05.view.InputView;
import step05.view.OutputView;

public class CoordinateCalculator {

	public void run() {
		try {
			List<int[]> coordinates = InputView.inputCoordinates();
			List<Point> points = PointFactory.create(coordinates);
			Figure figure = FigureFactory.create(points);
			OutputView.showCoordinate(figure);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			run();
		}
	}
}