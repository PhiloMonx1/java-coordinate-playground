package javajigi.view;

import javajigi.model.Figure;
import javajigi.model.FigureFactory;
import javajigi.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";
    private static final String ERROR_DUPLICATE_POINTS = "중복된 좌표가 존재합니다.";
    private static final String POINT_DELIMITER = "-";
    private static Scanner scanner = new Scanner(System.in); //*1

    public static Figure inputCoordinates() {
        System.out.println(INPUT_COORDINATE);
        return inputCoordinates(scanner.nextLine());
    }

    public static Figure inputCoordinates(String input) {
        try {
            input = input.replace(" ", "");
            checkAccuracyOfPoints(input);
            List<Point> points = generatePoints(input);
            return FigureFactory.create(points); //*2
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static void checkAccuracyOfPoints(String input) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
        }
    }

    private static List<Point> generatePoints(String input) {
        String[] inputPoints = input.split(POINT_DELIMITER);

        List<Point> points = new ArrayList<>();
        for (String inputPoint : inputPoints) {
            points.add(generatePoint(inputPoint));
        }
        checkDuplicationOf(points);
        return points;
    }

    private static Point generatePoint(String inputPoint) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(inputPoint);
        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
    }

    private static void checkDuplicationOf(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS);
        }
    }
}
/*
  _03 _Next : FigureFactory
  public 메서드와 private 메서드가 있으며, private 메서드는 사용자 입력 값에 대한 밸리데이션 및 Point 인스턴스 생성으로 이루어져 있다.
  *1. 지금까지 Scanner를 Main에 선언했었는데, View 클래스 내부에 선언하는 것이 인상깊었다.
  *2. FigureFactory.create() 를 통해서 View 클래스가 직접 Figure 객체를 생성하고 리턴하는 것이 인상깊었다.
      (View에서 생성자를 호출하게 되는 것이 이상하다고 생각했는데, 어쩌면 input View 라서 가능한게 아닐까?
      사실상 생성자를 직접 생성하는 주체는 팩토리 클래스이기 때문에 같은 작업을 Main에서 했던 내 코드에 비교했을 때는 더 나아보인다.
      다만 View가 Figure 및 FigureFactory에 의존하게 되는 것이 마음에 걸린다. 다른 방법이 있을까?)

  밸리데이션에 관련된 메서드는 좀 더 읽어보면서 파악해야 할 것 같다. 제목으로 어떤 동작을 수행하는지 알려주는 것은 매우 중요하다고 느꼈다.
  특히 Point를 생성할 때도 밸리데이션이 같이 포함되는데, 분리하는게 더 나은지도 고민이 된다.
  또한 pattern의 경우 각 패턴이 수행하는 작업을 해석하기 위해서 정규식을 직접 해석해야 하는데, 이것도 별도 주석이나, pattern을 상수로 등록하는 등의
  추가 작업이 있다면 더 가독성이 좋을지 고민이되었다.
 */