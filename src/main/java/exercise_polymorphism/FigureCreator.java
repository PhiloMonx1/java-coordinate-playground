package exercise_polymorphism;

import java.util.List;

public interface FigureCreator {
    Figure create(List<Point> points);
}
