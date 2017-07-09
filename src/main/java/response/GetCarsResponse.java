package response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import objects.Car;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "car"
})
@XmlRootElement(namespace = "http://dau.lam.net/service", name = "GetCarsResponse")
public class GetCarsResponse {

    @XmlElement(required = true)
    protected Car[] car;

    // public Car getCar() {
    //     return car;
    // }

    // public void setCar(Car value) {
    //     this.car = value;
    // }

    public Car[] getCars() {
        return car;
    }

    public void setCars(Car[] value) {
        this.car = value;
    }

}