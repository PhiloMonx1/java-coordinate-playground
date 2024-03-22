package step05.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import step05.model.FigureType;

public class InputView {

	private static final String INPUT_COORDINATE = "좌표를 입력하세요.";
	private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";
	private static final String ERROR_DUPLICATE_COORDINATES = "중복된 좌표가 존재합니다.";
	private static final String COORDINATES_DELIMITER = "-";
	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
		throw new IllegalStateException(this.getClass().getSimpleName() + "는 유틸리티 클래스입니다.");
	}

	public static List<int[]> inputCoordinates() {
		System.out.println(INPUT_COORDINATE);
		return inputCoordinates(scanner.nextLine());
	}

	private static List<int[]> inputCoordinates(String input) {
		try {
			input = input.replace(" ", "");
			checkAccuracyOfCoordinates(input);
			return generateCoordinates(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputCoordinates();
		}
	}

	private static void checkAccuracyOfCoordinates(String input) {
		String regex = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,"
				+ FigureType.getMaxVertices() + "}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
		}
	}

	private static List<int[]> generateCoordinates(String input) {
		String[] inputCoordinates = input.split(COORDINATES_DELIMITER);

		List<int[]> coordinate = new ArrayList<>();
		for (String inputCoordinate : inputCoordinates) {
			coordinate.add(generateCoordinate(inputCoordinate));
		}
		checkDuplicationOf(coordinate);
		return coordinate;
	}

	private static int[] generateCoordinate(String inputCoordinate) {
		Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
		Matcher matcher = pattern.matcher(inputCoordinate);
		if (matcher.find()) {
			int x = Integer.parseInt(matcher.group(1));
			int y = Integer.parseInt(matcher.group(2));
			return new int[]{x, y};
		}
		throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
	}

	private static void checkDuplicationOf(List<int[]> coordinates) {
		if (coordinates.size() != new HashSet<>(coordinates).size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_COORDINATES);
		}
	}
}
