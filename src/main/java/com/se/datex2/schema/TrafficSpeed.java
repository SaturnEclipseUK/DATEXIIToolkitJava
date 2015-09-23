//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Averaged measurements or calculations of traffic speed.
 * 
 * <p>Java class for TrafficSpeed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficSpeed">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/2/2_0}TrafficData">
 *       &lt;sequence>
 *         &lt;element name="averageVehicleSpeed" type="{http://datex2.eu/schema/2/2_0}SpeedValue" minOccurs="0"/>
 *         &lt;element name="speedPercentile" type="{http://datex2.eu/schema/2/2_0}SpeedPercentile" minOccurs="0"/>
 *         &lt;element name="trafficSpeedExtension" type="{http://datex2.eu/schema/2/2_0}_TrafficSpeedExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficSpeed", propOrder = {
    "averageVehicleSpeed",
    "speedPercentile",
    "trafficSpeedExtension"
})
public class TrafficSpeed
    extends TrafficData
{

    protected SpeedValue averageVehicleSpeed;
    protected SpeedPercentile speedPercentile;
    protected TrafficSpeedExtensionType trafficSpeedExtension;

    /**
     * Gets the value of the averageVehicleSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedValue }
     *     
     */
    public SpeedValue getAverageVehicleSpeed() {
        return averageVehicleSpeed;
    }

    /**
     * Sets the value of the averageVehicleSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedValue }
     *     
     */
    public void setAverageVehicleSpeed(SpeedValue value) {
        this.averageVehicleSpeed = value;
    }

    /**
     * Gets the value of the speedPercentile property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedPercentile }
     *     
     */
    public SpeedPercentile getSpeedPercentile() {
        return speedPercentile;
    }

    /**
     * Sets the value of the speedPercentile property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedPercentile }
     *     
     */
    public void setSpeedPercentile(SpeedPercentile value) {
        this.speedPercentile = value;
    }

    /**
     * Gets the value of the trafficSpeedExtension property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficSpeedExtensionType }
     *     
     */
    public TrafficSpeedExtensionType getTrafficSpeedExtension() {
        return trafficSpeedExtension;
    }

    /**
     * Sets the value of the trafficSpeedExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficSpeedExtensionType }
     *     
     */
    public void setTrafficSpeedExtension(TrafficSpeedExtensionType value) {
        this.trafficSpeedExtension = value;
    }

}
