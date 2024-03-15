package step01.domain;


import java.util.ArrayList;
import java.util.List;

public class RentCompany {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final List<Car> rentCars = new ArrayList<>();
	public static RentCompany create() {
		return new RentCompany();
	}

	public void addCar(Car car) {
		rentCars.add(car);
	}

	public String generateReport() {
		StringBuilder report = new StringBuilder();
		for(Car rentCar : rentCars) {
			report.append(rentCar.getName()).append(" : ").append(Math.round(rentCar.getChargeQuantity()))
					.append("리터").append(NEWLINE);
		}
		return report.toString();
	}
}
