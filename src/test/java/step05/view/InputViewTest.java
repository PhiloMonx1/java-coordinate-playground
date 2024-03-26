package step05.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step05.model.Figure;
import step05.model.FigureFactory;
import step05.model.Point;
import step05.model.PointFactory;

class InputViewTest {
    private final InputStream systemInBackup = System.in;
    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void 사용자_입력에_따른_Line_생성() {
        List<int[]> inputCoordinates = InputView.inputCoordinates("(1, 1) - (2, 2)");
        List<Point> inputPoints = PointFactory.create(inputCoordinates);
        Figure figure = FigureFactory.create(inputPoints);

        List<int[]> coordinates = new ArrayList<>();
        coordinates.add(new int[]{1, 1});
        coordinates.add(new int[]{2, 2});
        points = PointFactory.create(coordinates);

        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @Test
    void 사용자_입력에_따른_Triangle_생성() {
        List<int[]> inputCoordinates = InputView.inputCoordinates("(1, 1) - (3, 2) - (2, 5)");
        List<Point> inputPoints = PointFactory.create(inputCoordinates);
        Figure figure = FigureFactory.create(inputPoints);

        List<int[]> coordinates = new ArrayList<>();
        coordinates.add(new int[]{1, 1});
        coordinates.add(new int[]{3, 2});
        coordinates.add(new int[]{2, 5});
        points = PointFactory.create(coordinates);

        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @Test
    void 사용자_입력에_따른_Rectangle_생성() {
        List<int[]> inputCoordinates = InputView.inputCoordinates("(1, 5) - (3, 5) - (1, 3) - (3, 3)");
        List<Point> inputPoints = PointFactory.create(inputCoordinates);
        Figure figure = FigureFactory.create(inputPoints);

        List<int[]> coordinates = new ArrayList<>();
        coordinates.add(new int[]{1, 5});
        coordinates.add(new int[]{3, 5});
        coordinates.add(new int[]{1, 3});
        coordinates.add(new int[]{3, 3});
        points = PointFactory.create(coordinates);

        assertThat(figure).isEqualTo(FigureFactory.create(points));
    }

    @AfterEach
    void tearDown() {
        points = null;
        System.setIn(systemInBackup);
    }
}
