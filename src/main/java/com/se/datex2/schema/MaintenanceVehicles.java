//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Details of the maintenance vehicles involved in the roadworks activity.
 * 
 * <p>Java class for MaintenanceVehicles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaintenanceVehicles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfMaintenanceVehicles" type="{http://datex2.eu/schema/2/2_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="maintenanceVehicleActions" type="{http://datex2.eu/schema/2/2_0}MaintenanceVehicleActionsEnum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maintenanceVehiclesExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaintenanceVehicles", propOrder = {
    "numberOfMaintenanceVehicles",
    "maintenanceVehicleActions",
    "maintenanceVehiclesExtension"
})
public class MaintenanceVehicles {

    protected BigInteger numberOfMaintenanceVehicles;
    protected List<MaintenanceVehicleActionsEnum> maintenanceVehicleActions;
    protected ExtensionType maintenanceVehiclesExtension;

    /**
     * Gets the value of the numberOfMaintenanceVehicles property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfMaintenanceVehicles() {
        return numberOfMaintenanceVehicles;
    }

    /**
     * Sets the value of the numberOfMaintenanceVehicles property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfMaintenanceVehicles(BigInteger value) {
        this.numberOfMaintenanceVehicles = value;
    }

    /**
     * Gets the value of the maintenanceVehicleActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintenanceVehicleActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintenanceVehicleActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaintenanceVehicleActionsEnum }
     * 
     * 
     */
    public List<MaintenanceVehicleActionsEnum> getMaintenanceVehicleActions() {
        if (maintenanceVehicleActions == null) {
            maintenanceVehicleActions = new ArrayList<MaintenanceVehicleActionsEnum>();
        }
        return this.maintenanceVehicleActions;
    }

    /**
     * Gets the value of the maintenanceVehiclesExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getMaintenanceVehiclesExtension() {
        return maintenanceVehiclesExtension;
    }

    /**
     * Sets the value of the maintenanceVehiclesExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setMaintenanceVehiclesExtension(ExtensionType value) {
        this.maintenanceVehiclesExtension = value;
    }

}
