package step04;

import java.util.Scanner;
import step04.domain.Geometry;
import step04.view.CoordinateView;

public class CoordinateApplication {

	private static final String ASK_COORDINATE = "좌표를 입력하세요.";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ASK_COORDINATE);
		String input = scanner.nextLine();

		CoordinateView view = new CoordinateView();

		Geometry geometry = Geometry.crate(input);
		view.printResult(geometry);
	}
}
