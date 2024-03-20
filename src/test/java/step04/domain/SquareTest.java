package step04.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SquareTest {
	@Test
	@DisplayName("사각형의 넓이를 리턴한다.")
	void areaTest(){
		Point pointOne = new Point("10,10");
		Point pointTwo = new Point("22,10");
		Point pointThree = new Point("22,18");
		Point pointFour = new Point("10,18");

		Square puddleSquare = new Square(pointOne, pointThree, pointTwo, pointFour);
		assertThat(puddleSquare.area()).isEqualTo(96, offset(0.00099));
	}
}