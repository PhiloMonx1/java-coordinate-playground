package step05.utils;

public class MathUtil {
	public static double squareDifference(int firstValue, int secondValue) {
		return Math.pow(firstValue - secondValue, 2);
	}

	public static double calculateFormulaOfHeron(double firstSide, double secondSide, double thirdSide) {
		double s = (firstSide + secondSide + thirdSide) / 2;

		return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
	}
}
