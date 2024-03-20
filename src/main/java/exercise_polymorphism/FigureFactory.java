package exercise_polymorphism;

import java.util.List;

public class FigureFactory {
    static Figure getInstance(List<Point> points) {
        return FigureCreator.create(points);
    }
}
