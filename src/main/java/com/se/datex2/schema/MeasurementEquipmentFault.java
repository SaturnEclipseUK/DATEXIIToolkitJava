//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details of a fault which is being reported for the related measurement equipment.
 * 
 * <p>Java class for MeasurementEquipmentFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasurementEquipmentFault">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/2/2_0}Fault">
 *       &lt;sequence>
 *         &lt;element name="measurementEquipmentFault" type="{http://datex2.eu/schema/2/2_0}MeasurementEquipmentFaultEnum"/>
 *         &lt;element name="measurementEquipmentFaultExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementEquipmentFault", propOrder = {
    "measurementEquipmentFault",
    "measurementEquipmentFaultExtension"
})
public class MeasurementEquipmentFault
    extends Fault
{

    @XmlElement(required = true)
    protected MeasurementEquipmentFaultEnum measurementEquipmentFault;
    protected ExtensionType measurementEquipmentFaultExtension;

    /**
     * Gets the value of the measurementEquipmentFault property.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementEquipmentFaultEnum }
     *     
     */
    public MeasurementEquipmentFaultEnum getMeasurementEquipmentFault() {
        return measurementEquipmentFault;
    }

    /**
     * Sets the value of the measurementEquipmentFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementEquipmentFaultEnum }
     *     
     */
    public void setMeasurementEquipmentFault(MeasurementEquipmentFaultEnum value) {
        this.measurementEquipmentFault = value;
    }

    /**
     * Gets the value of the measurementEquipmentFaultExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getMeasurementEquipmentFaultExtension() {
        return measurementEquipmentFaultExtension;
    }

    /**
     * Sets the value of the measurementEquipmentFaultExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setMeasurementEquipmentFaultExtension(ExtensionType value) {
        this.measurementEquipmentFaultExtension = value;
    }

}
