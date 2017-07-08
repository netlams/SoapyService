package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import request.GetCarsRequest;
import response.GetCarsResponse;

@Endpoint
public class CarEndpoint {
	private static final String NAMESPACE_URI = "http://dau.lam.net";

	private CarRepository carRepository;

	@Autowired
	public CarEndpoint(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@PayloadRoot(localPart = "getCarsRequest")
	@ResponsePayload
	public GetCarsResponse getCars(@RequestPayload GetCarsRequest request) {
		GetCarsResponse response = new GetCarsResponse();
		response.setCar(carRepository.getCars());

		return response;
	}
}
