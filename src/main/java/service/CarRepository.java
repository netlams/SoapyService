package service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import objects.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
* Load an instance of this class at startup
*
*/ 
@Component
public class CarRepository {

	// in-memory storage of data for demo
	private static final Map<String, Car> cars = new HashMap<>();

	@PostConstruct
	public void initData() {
		// creation of default  initial data
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

	public boolean createCar(String name, String color, double fuelAmt, String type) {
		try {

			Car car = null;

			switch (type) {
				case "GAS" :
					car = new GasolineFueledImp();
					car.setName(name.toUpperCase());
					car.setColor(color.toUpperCase());
					car.setFuelAmount(fuelAmt);

					type = type.toUpperCase();
					car.setCarType(CarType.GAS);
					break;
				case "ELECTRIC" :
					car = new ElectricFueledImp();
					car.setName(name.toUpperCase());
					car.setColor(color.toUpperCase());
					car.setFuelAmount(fuelAmt);

					type = type.toUpperCase();
					car.setCarType(CarType.ELECTRIC);
					break;
			}
			if (car != null)
				cars.put(car.getName(), car);

			return true;
		} catch (Exception ex ) {
			return false;
		}
	}

        
    /**
     * Query and return the specific car 
     *
     * @param name
     * @return an array of one car
     */
	public Car[] getCar(String name) {	
		Car[] car = new Car[1];
		car[0] = cars.get(name.toUpperCase());
		return car;
	}

    /**
     * Returns an array of all cars 
     *
     * @return 
     */
	public Car[] getCars() {	
		// get all car names
		String[] keys = cars.keySet().toArray(new String[0]);

		// empty array to be returned later
		Car[] array = new Car[keys.length];

		int i = 0;

		for(String name : keys) {
			// get and set to array
			array[i] = cars.get(name);
			i++;
		}

		return array;
	}
}
