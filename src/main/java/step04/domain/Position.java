package step04.domain;

public class Position {

	private final int position;

	public Position(int position) {
		if (position < 0 || position > 24) {
			throw new IllegalArgumentException("Position은 0부터 24까지의 숫자만 가능합니다.");
		}
		this.position = position;
	}

	public Position(String position) {
		this(validate(position));
	}

	public int getPosition() {
		return position;
	}

	private static int validate(String input) {
		input = input.replaceAll("[^0-9]", "");
		return Integer.parseInt(input);
	}
}
