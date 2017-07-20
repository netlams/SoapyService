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
    "response",
    "speed"
})

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "getZeroToSixtyResponse")
public class GetZeroToSixtyResponse {

    @XmlElement(required = true)
    protected Response response = new Response();

     @XmlElement(required = true)
    protected double speed; // array list 

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double s) {
        this.speed = s;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response r) {
        this.response = r;
    }
}