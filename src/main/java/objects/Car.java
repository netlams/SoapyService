package objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", propOrder = {
    "name",
    "color",
    "fuelAmount",
    "carType"
})
public class Car {

    @XmlElement(required = true)
    protected String name;
    
    @XmlElement(required = true)
    protected String color;
    
    @XmlElement(required = true)
    protected int fuelAmount;
    
    @XmlElement(required = true)
    protected CarType carType;

    public String getName() {
    	return this.name;
    }

    public void setName(String n) {
    	this.name = n;
    }

    public String getColor() {
    	return this.color;
    }

    public void setColor(String c) {
    	this.color = c;
    }

    public int getFuelAmount() {
    	return this.fuelAmount;
    }

    public void setFuelAmount(int f) {
    	this.fuelAmount = f;
    }

    public CarType getCarType() {
    	return this.carType;
    }

    public void setCarType(CarType c) {
    	this.carType = c;
    }
}