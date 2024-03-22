package step05.model;

public class Coordinate {

	private static final int LOWER_LIMIT = 1;
	private static final int UPPER_LIMIT = 24;
	private static final String ERROR_OUT_OF_POSITION_RANGE =
			"허용되지 않는 좌표 값 입니다. " + LOWER_LIMIT + " ~ " + UPPER_LIMIT + " 사이의 정수로 입력해 주세요.";

	private final int position;

	public Coordinate(int position) {
		checkRangeOf(position);
		this.position = position;
	}

	private void checkRangeOf(int coordinate) {
		if (coordinate < LOWER_LIMIT || coordinate > UPPER_LIMIT) {
			throw new IllegalArgumentException(ERROR_OUT_OF_POSITION_RANGE);
		}
	}

	int getPosition() {
		return position;
	}
}