//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A measured or calculated value of distance in whole metres.
 * 
 * <p>Java class for IntegerMetreDistanceValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegerMetreDistanceValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/2/2_0}DataValue">
 *       &lt;sequence>
 *         &lt;element name="integerMetreDistance" type="{http://datex2.eu/schema/2/2_0}MetresAsNonNegativeInteger"/>
 *         &lt;element name="integerMetreDistanceValueExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegerMetreDistanceValue", propOrder = {
    "integerMetreDistance",
    "integerMetreDistanceValueExtension"
})
public class IntegerMetreDistanceValue
    extends DataValue
{

    @XmlElement(required = true)
    protected BigInteger integerMetreDistance;
    protected ExtensionType integerMetreDistanceValueExtension;

    /**
     * Gets the value of the integerMetreDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIntegerMetreDistance() {
        return integerMetreDistance;
    }

    /**
     * Sets the value of the integerMetreDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIntegerMetreDistance(BigInteger value) {
        this.integerMetreDistance = value;
    }

    /**
     * Gets the value of the integerMetreDistanceValueExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getIntegerMetreDistanceValueExtension() {
        return integerMetreDistanceValueExtension;
    }

    /**
     * Sets the value of the integerMetreDistanceValueExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setIntegerMetreDistanceValueExtension(ExtensionType value) {
        this.integerMetreDistanceValueExtension = value;
    }

}
