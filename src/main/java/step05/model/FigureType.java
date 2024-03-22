package step05.model;

import java.util.Arrays;

public enum FigureType {
	LINE(2),
	TRIANGLE(3),
	RECTANGLE(4),

	;

	private final int vertices;

	FigureType(int vertices) {
		this.vertices = vertices;
	}

	public int getVertices() {
		return vertices;
	}

	public static int getMinVertices() {
		return Arrays.stream(FigureType.values())
				.mapToInt(FigureType::getVertices)
				.min()
				.orElse(0);
	}
	public static int getMaxVertices() {
		return Arrays.stream(FigureType.values())
				.mapToInt(FigureType::getVertices)
				.max()
				.orElse(0);
	}
}
