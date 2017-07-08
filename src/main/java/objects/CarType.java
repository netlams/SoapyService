package objects;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "carType")
@XmlEnum
public enum CarType {

    GAS,
    ELECTRIC;

    public String value() {
        return name();
    }

    public static CarType fromValue(String v) {
        return valueOf(v);
    }

}