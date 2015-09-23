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
 * <p>Java class for DangerousGoodsRegulationsEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DangerousGoodsRegulationsEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="adr"/>
 *     &lt;enumeration value="iataIcao"/>
 *     &lt;enumeration value="imoImdg"/>
 *     &lt;enumeration value="railroadDangerousGoodsBook"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DangerousGoodsRegulationsEnum")
@XmlEnum
public enum DangerousGoodsRegulationsEnum {


    /**
     * European agreement on the international carriage of dangerous goods on road.
     * 
     */
    @XmlEnumValue("adr")
    ADR("adr"),

    /**
     * Regulations covering the international transportation of dangerous goods issued by the International Air Transport Association and the International Civil Aviation Organisation.
     * 
     */
    @XmlEnumValue("iataIcao")
    IATA_ICAO("iataIcao"),

    /**
     * Regulations regarding the transportation of dangerous goods on ocean-going vessels issued by the International Maritime Organisation.
     * 
     */
    @XmlEnumValue("imoImdg")
    IMO_IMDG("imoImdg"),

    /**
     * International regulations concerning the international carriage of dangerous goods by rail.
     * 
     */
    @XmlEnumValue("railroadDangerousGoodsBook")
    RAILROAD_DANGEROUS_GOODS_BOOK("railroadDangerousGoodsBook");
    private final String value;

    DangerousGoodsRegulationsEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DangerousGoodsRegulationsEnum fromValue(String v) {
        for (DangerousGoodsRegulationsEnum c: DangerousGoodsRegulationsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
