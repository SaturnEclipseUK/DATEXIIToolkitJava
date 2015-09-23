//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinearElementNatureEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LinearElementNatureEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="road"/>
 *     &lt;enumeration value="roadSection"/>
 *     &lt;enumeration value="slipRoad"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LinearElementNatureEnum")
@XmlEnum
public enum LinearElementNatureEnum {


    /**
     * The nature of the linear element is a road.
     * 
     */
    @XmlEnumValue("road")
    ROAD("road"),

    /**
     * The nature of the linear element is a section of a road.
     * 
     */
    @XmlEnumValue("roadSection")
    ROAD_SECTION("roadSection"),

    /**
     * The nature of the linear element is a slip road.
     * 
     */
    @XmlEnumValue("slipRoad")
    SLIP_ROAD("slipRoad"),

    /**
     * Other than as defined in this enumeration.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    LinearElementNatureEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinearElementNatureEnum fromValue(String v) {
        for (LinearElementNatureEnum c: LinearElementNatureEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
