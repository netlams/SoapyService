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
    "result"
})

@XmlRootElement(namespace = "http://dau.lam.net/service", name = "startCarResponse")
public class StartCarResponse {

    @XmlElement(required = true)
    protected Response response = new Response();

     @XmlElement(required = true)
    protected boolean result; // array list 

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean r) {
        this.result = r;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response r) {
        this.response = r;
    }
}