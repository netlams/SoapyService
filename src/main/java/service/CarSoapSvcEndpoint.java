package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import request.CreateCarRequest;
import response.CreateCarResponse;
import request.GetCarsRequest;
import response.GetCarsResponse;
import objects.Response;

/**
* Endpoint for all requests
* 
*/
@Endpoint
public class CarSoapSvcEndpoint {
	private static final String NAMESPACE_URI = "http://dau.lam.net/service";

	private CarRepository carRepository;

	@Autowired
	public CarSoapSvcEndpoint(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCarRequest")
	@ResponsePayload
	public CreateCarResponse createCar(@RequestPayload CreateCarRequest request) {
		CreateCarResponse response = new CreateCarResponse();

		// validate required / mandatory fields 
		if (request.getName() == null || request.getColor() == null || request.getCarType() == null ) {
			System.out.println("Missing or empty fields in creation");

			Response respData = new Response("The operation failed", 1, " Missing required fields");
			response.setResponse(respData);
		}
		// validate expected field values
		else if (!request.getCarType().equalsIgnoreCase("GAS") && !request.getCarType().equalsIgnoreCase("ELECTRIC")) {
			System.out.println("Invalid fields in creation");

			Response respData = new Response("The operation failed", 2, "Invalid field values - Available carTypes are : [GAS, ELECTRIC]");
			response.setResponse(respData);
		}
		// all validation passed, create object and add to memory
		else {
			carRepository.createCar(request.getName(), request.getColor(), request.getFuelAmount(), request.getCarType());
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarsRequest")
	@ResponsePayload
	public GetCarsResponse getCars(@RequestPayload GetCarsRequest request) {
		GetCarsResponse response = new GetCarsResponse();

		// optional name field
		if (request.getName() != null && request.getName().length() > 0 ) {
			response.setCars(carRepository.getCar(request.getName()));
		}
		// get all objects in memory
		else {
			response.setCars(carRepository.getCars());
		}

		return response;
	}
}
