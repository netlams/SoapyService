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

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "getZeroToSixtyRequest")
public class GetZeroToSixtyRequest {

			@XmlElement(required = true)
		    protected String name;

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
}