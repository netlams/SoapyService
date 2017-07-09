package request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name"
})
@XmlRootElement(namespace = "http://dau.lam.net/service", name = "getCars")
public class GetCars {
	
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