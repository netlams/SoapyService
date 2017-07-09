package service;

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
		sedan.setName("HONDA CIVIC");
		sedan.setColor("RED");
		sedan.setFuelAmount(0);
		sedan.setCarType(CarType.GAS);

		cars.put(sedan.getName(), sedan);

		Car sedan2 = new Car();
		sedan2.setName("SUBARU LEGACY");
		sedan2.setColor("BLACK");
		sedan2.setFuelAmount(0);
		sedan2.setCarType(CarType.GAS);

		cars.put(sedan2.getName(), sedan2);
	}

	public Car[] getCar(String name) {	
		Car[] car = new Car[1];
		car[0] = cars.get(name);
		return car;
	}

	public Car[] getCars() {	
		String[] keys = cars.keySet().toArray(new String[0]);
		Car[] array = new Car[keys.length];

		int i = 0;

		for(String name : keys) {
			System.out.println("keys" + name);
			array[i] = cars.get(name);
			i++;
		}

		return array;
	}
}
