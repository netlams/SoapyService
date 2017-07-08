package hello;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import objects.Car;
import objects.CarType;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CarRepository {
	private static final Map<String, Car> cars = new HashMap<>();

	@PostConstruct
	public void initData() {
		Car sedan = new Car();
		sedan.setName("Honda Civic");
		sedan.setColor("red");
		sedan.setFuelAmount(0);
		sedan.setCarType(CarType.GAS);

		cars.put(sedan.getName(), sedan);
	}

	public Car getCars() {
		
		return cars.get("Honda Civic");
	}
}
