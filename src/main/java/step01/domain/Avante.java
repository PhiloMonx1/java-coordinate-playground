package step01.domain;

public class Avante extends Car {
	private static final Double DISTANCE_PER_LITER = 15.0;

	private final Double tripDistance;

	public Avante(int tripDistance) {
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
		return "Avante";
	}
}
