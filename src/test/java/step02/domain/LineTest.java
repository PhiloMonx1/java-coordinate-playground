package step02.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
	@Test
	@DisplayName("선의 길이를 리턴한다.")
	void lengthTest(){
		Point start = new Point(new Position(10), new Position(10));
		Point end = new Point(new Position(14), new Position(15));
		Line line = new Line(start, end);
		assertThat(line.length()).isEqualTo(6.403124, offset(0.00099));
	}
}