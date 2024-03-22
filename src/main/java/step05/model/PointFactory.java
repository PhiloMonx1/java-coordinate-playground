package step05.model;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {
	private PointFactory(){
		throw new IllegalStateException(this.getClass().getSimpleName() + "는 유틸리티 클래스입니다.");
	}

	public static List<Point> create(List<int[]> coordinates) {
		List<Point> points = new ArrayList<>();
		for (int[] coordinate : coordinates) {
			points.add(new Point(coordinate[0], coordinate[1]));
		}
		return points;
	}
}
