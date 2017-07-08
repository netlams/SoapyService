package request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getCarsRequest")
public class GetCarsRequest {
		@XmlElement(required = true)
	    protected String name;

	    /**
	     * Gets the value of the name property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * Sets the value of the name property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setName(String value) {
	        this.name = value;
	    }
}