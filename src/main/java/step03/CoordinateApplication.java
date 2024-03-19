package step03;

import java.util.Scanner;
import step03.domain.Line;
import step03.domain.Square;
import step03.view.CoordinateView;

public class CoordinateApplication {

	private static final String ASK_COORDINATE = "좌표를 입력하세요.";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ASK_COORDINATE);
		String input = scanner.nextLine();

		CoordinateView view = new CoordinateView();

		if (input.split("-").length == 2) {
			view.printResult(new Line(input));
		}

		if (input.split("-").length == 4) {
			view.printResult(new Square(input));
		}
	}
}
