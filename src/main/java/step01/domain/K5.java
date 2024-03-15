package step01.domain;

public class K5 extends Car {
	private static final Double DISTANCE_PER_LITER = 13.0;

	private final Double tripDistance;

	public K5(int tripDistance) {
		this.tripDistance = (double) tripDistance;
	}

	@Override
	double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	@Override
	double getTripDistance() {
		return this.tripDistance;
	}

	@Override
	String getName() {
		return "K5";
	}
}
