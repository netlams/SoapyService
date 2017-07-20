package service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import objects.*;

@RestController
public class CarRestSvcController {

    private CarRepository carRepository;

	@Autowired
	public CarRestSvcController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

    @RequestMapping(value="/rest/cars", method=RequestMethod.POST)
    public ResponseEntity<Response> createCar(@RequestBody Car request) {
    	System.out.println("Creating car: " + request.getName());
    	Response respData = new Response();

    	// validate required / mandatory fields 
		if (request.getName() == null || request.getColor() == null || request.getCarType() == null ) {
			System.out.println("Missing or empty fields in creation");

			respData = new Response("The operation failed", 1, " Missing required fields");
			return new ResponseEntity<Response>(respData, HttpStatus.BAD_REQUEST);
		}
		// validate expected field values
		else if (request.getCarType()!=CarType.GAS && request.getCarType()!=CarType.ELECTRIC) {
			System.out.println("Invalid fields in creation");

			respData = new Response("The operation failed", 2, "Invalid field values - Available carTypes are : [GAS, ELECTRIC]");
			return new ResponseEntity<Response>(respData, HttpStatus.BAD_REQUEST);
		}
		// all validation passed, create object and add to memory
		else {
			carRepository.createCar(request.getName(), request.getColor(), request.getFuelAmount(), request.getCarType().value());
			return new ResponseEntity<Response>(respData, HttpStatus.OK);
		}
		
    }

    @RequestMapping(value="/rest/cars", method=RequestMethod.GET)
    public Car[] getCars(@RequestParam(value="name", defaultValue="*") String name) {
    	if (name.equals("*"))
        	return carRepository.getCars();
        else 
        	return carRepository.getCar(name);
    }

    @RequestMapping(value="/rest/start", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> startCar(@RequestParam(value="name", defaultValue="*") String name) {
    	try {
    		Boolean result = (Boolean)carRepository.startCar(name);
    		
			String response = "{" 	
								+ "\"result\": " 
								+ result.toString()
								+ "}";
			return new ResponseEntity<String>(response, HttpStatus.OK);
    	}
    	catch (Exception ex) {
    		return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    	} 
    }

    @RequestMapping(value="/rest/zerotosixty", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getZeroToSixtySpeed(@RequestParam(value="name") String name) {
    	try {
	        Double result = (Double)carRepository.getZeroToSixtySpeed(name);
	        
	    	String response = "{" 	+ "\"result\": " 
	    				+ result.toString()
	    				+ "}";
	    	return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        catch (Exception ex) {
        	return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
        }
    }
}