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
    "response"
})

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "CreateCarResponse")
public class CreateCarResponse {

    @XmlElement(required = true)
    protected Response response = new Response();

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response r) {
        this.response = r;
    }
}