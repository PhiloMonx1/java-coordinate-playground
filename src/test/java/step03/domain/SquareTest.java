package step03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SquareTest {
	@Test
	@DisplayName("사각형의 넓이를 리턴한다.")
	void areaTest(){
		Point pointSW = new Point("10,10");
		Point pointSE = new Point("22,10");
		Point pointNE = new Point("22,18");
		Point pointNW = new Point("10,18");

		Square square = new Square(pointSW, pointSE, pointNE, pointNW);
		assertThat(square.area()).isEqualTo(96, offset(0.00099));
	}
}