package step05.model;

import java.util.ArrayList;
import java.util.List;
import step05.utils.Util;

public class PointFactory extends Util {
	private PointFactory(){
		super();
	}

	public static List<Point> create(List<int[]> coordinates) {
		List<Point> points = new ArrayList<>();
		for (int[] coordinate : coordinates) {
			points.add(new Point(coordinate[0], coordinate[1]));
		}
		return points;
	}
}
