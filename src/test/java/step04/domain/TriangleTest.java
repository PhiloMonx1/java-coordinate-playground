package step04.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest {
	@Test
	@DisplayName("삼각형의 넓이를 리턴한다.")
	void areaTest(){

		Point pointOne = new Point("10,10");
		Point pointTwo = new Point("14,15");
		Point pointThree = new Point("20,8");

		Triangle triangle = new Triangle(pointOne, pointTwo, pointThree);
		assertThat(triangle.area()).isEqualTo(29.0, offset(0.00099));
	}
}