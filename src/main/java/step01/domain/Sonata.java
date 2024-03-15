package step01.domain;

public class Sonata extends Car {
	private static final Double DISTANCE_PER_LITER = 10.0;
	private final Double tripDistance;

	public Sonata(int tripDistance) {
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
		return "Sonata";
	}
}
