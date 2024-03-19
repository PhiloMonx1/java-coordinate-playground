package step03.domain;

import java.util.Scanner;

public class Application {

	private static final String ASK_COORDINATE = "좌표를 입력하세요.";
	private static final String REPORT_RESULT = "두 점 사이 거리는 ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ASK_COORDINATE);
		String input = scanner.nextLine();
		System.out.println(REPORT_RESULT + new Line(input).length());
	}
}
