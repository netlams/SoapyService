package request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "color",
    "fuelAmount",
    "carType"
})

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "createCarRequest")
public class CreateCarRequest {

			@XmlElement(required = true)
		    protected String name;

		    @XmlElement(required = true)
		    protected String color;

		    protected int fuelAmount;

		    @XmlElement(required = true)
		    protected String carType;

		    /**
		     * Gets the value of the name property.
		     * 
		     * @return the name   
		     */
		    public String getName() {
		        return name;
		    }

		    /**
		     * Sets the value of the name property.
		     * 
		     * @param value to set 
		     */
		    public void setName(String value) {
		        this.name = value;
		    }

		    /**
		     * Gets the value of the color property.
		     * 
		     * @return the name   
		     */
		    public String getColor() {
		        return color;
		    }

		    /**
		     * Sets the value of the color property.
		     * 
		     * @param value to set 
		     */
		    public void setColor(String value) {
		        this.color = value;
		    }

		    /**
		     * Gets the value of the FuelAmount property.
		     * 
		     * @return the FuelAmount  
		     */
		    public int getFuelAmount() {
		        return fuelAmount;
		    }

		    /**
		     * Sets the value of the FuelAmount property.
		     * 
		     * @param value to set 
		     */
		    public void setFuelAmount(int value) {
		        this.fuelAmount = value;
		    }

		    /**
		     * Gets the value of the CarType property.
		     * 
		     * @return the CarType   
		     */
		    public String getCarType() {
		        return carType;
		    }

		    /**
		     * Sets the value of the CarType property.
		     * 
		     * @param value to set 
		     */
		    public void setCarType(String value) {
		        this.carType = value;
		    }
}