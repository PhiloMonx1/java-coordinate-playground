package step02.domain;

public class Position {

	private final int position;

	public Position(int position) {
		if (position < 0 || position > 24) {
			throw new IllegalArgumentException("Position은 0부터 24까지의 숫자만 가능합니다.");
		}
		this.position = position;
	}

	public int getPosition() {
		return position;
	}
}
