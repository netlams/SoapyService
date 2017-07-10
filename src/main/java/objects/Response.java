package objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "respMsg",
    "respCode",
    "exceptionMsg"
})
public class Response {

    @XmlElement(required = true)
    protected String respMsg;
    
    @XmlElement(required = true)
    protected int respCode;

    @XmlElement(required = true)
    protected String exceptionMsg;

    public Response() {
        this.respMsg = "The operation completed successfully";
        this.respCode = 0;
        this.exceptionMsg = "";
    }

    public Response(String msg, int code, String ex) {
        this.respMsg = msg;
        this.respCode = code;
        this.exceptionMsg = ex;
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

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String r) {
        this.exceptionMsg = r;
    }


}