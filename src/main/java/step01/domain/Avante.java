package step01.domain;

public class Avante implements Car {
	private static final double DISTANCE_PER_LITER = 15;
	private final double tripDistance;

	public Avante(int tripDistance) {
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
