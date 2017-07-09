package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import request.CreateCar;
import response.CreateCarResponse;
import request.GetCars;
import response.GetCarsResponse;


@Endpoint
public class CarEndpoint {
	private static final String NAMESPACE_URI = "http://dau.lam.net/service";

	private CarRepository carRepository;

	@Autowired
	public CarEndpoint(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@PayloadRoot(namespace = "http://dau.lam.net/service", localPart = "getCars")
	@ResponsePayload
	public GetCarsResponse getCars(@RequestPayload GetCars request) {
		GetCarsResponse response = new GetCarsResponse();

		// optional name field
		if (request.getName() != null && request.getName().length() > 0 ) {
			response.setCars(carRepository.getCar(request.getName()));
		}
		else {
			response.setCars(carRepository.getCars());
		}

		return response;
	}

	@PayloadRoot(namespace = "http://dau.lam.net/service", localPart = "createCar")
	@ResponsePayload
	public CreateCarResponse createCar(@RequestPayload CreateCar request) {
		CreateCarResponse response = new CreateCarResponse();

		carRepository.createCar(request.getName(), request.getColor(), request.getFuelAmount(), request.getCarType());

		return response;
	}
}
