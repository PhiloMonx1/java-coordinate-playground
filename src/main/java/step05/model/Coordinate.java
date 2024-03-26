package step05.model;

import java.util.Objects;

public class Coordinate {

	public static final int LOWER_LIMIT = 1;
	public static final int UPPER_LIMIT = 24;
	private static final String ERROR_OUT_OF_POSITION_RANGE =
			"허용되지 않는 좌표 값 입니다. " + LOWER_LIMIT + " ~ " + UPPER_LIMIT + " 사이의 정수로 입력해 주세요.";

	private final int position;

	Coordinate(int position) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Coordinate that = (Coordinate) o;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
