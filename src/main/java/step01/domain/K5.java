package step01.domain;

public class K5 implements Car {
	private static final double DISTANCE_PER_LITER = 13;
	private final double tripDistance;

	public K5(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	@Override
	public double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	@Override
	public double getTripDistance() {
		return tripDistance;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public double getChargeQuantity() {
		return getTripDistance() / getDistancePerLiter();
	}
}
