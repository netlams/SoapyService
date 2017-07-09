package objects;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "carType")
@XmlEnum
public enum CarType {

    GAS,
    ELECTRIC;
    
    /**
     * 
     * @return 
     */
    public String value() {
        return name();
    }
    
    /**
     * 
     * @param v
     * @return 
     */
    public static CarType fromValue(String v) {
        return valueOf(v);
    }

}