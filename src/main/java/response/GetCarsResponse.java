package response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import objects.Car;
import objects.Response;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "car", 
    "response"
})

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "GetCarsResponse")
public class GetCarsResponse {

    @XmlElement(required = true)
    protected Car[] car; // array list 

    @XmlElement(required = true)
    protected Response response = new Response();

    public Car[] getCars() {
        return car;
    }

    public void setCars(Car[] value) {
        this.car = value;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response r) {
        this.response = r;
    }
}