package objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "respMsg",
    "respCode"
})
public class Response {

    @XmlElement(required = true)
    protected String respMsg;
    
    @XmlElement(required = true)
    protected int respCode;

    public Response() {
        this.respMsg = "The operation completed successfully";
        this.respCode = 0;
    }

    public Response(String msg, int code) {
        this.respMsg = msg;
        this.respCode = code;
    }


    public String getRespMsg() {
    	return this.respMsg;
    }

    public void setRespMsg(String r) {
    	this.respMsg = r;
    }

    public int getRespCode() {
    	return this.respCode;
    }

    public void setRespCode(int c) {
    	this.respCode = c;
    }
}