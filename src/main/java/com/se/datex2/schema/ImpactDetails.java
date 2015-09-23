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
import javax.xml.bind.annotation.XmlType;


/**
 * Details of the impact of a situation/event.
 * 
 * <p>Java class for ImpactDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImpactDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeInCapacity" type="{http://datex2.eu/schema/2/2_0}Percentage" minOccurs="0"/>
 *         &lt;element name="increaseInDemand" type="{http://datex2.eu/schema/2/2_0}VehiclesPerHour" minOccurs="0"/>
 *         &lt;element name="individualLanesStatus" type="{http://datex2.eu/schema/2/2_0}IndividualLanesStatus" minOccurs="0"/>
 *         &lt;element name="returnToNormalStatus" type="{http://datex2.eu/schema/2/2_0}ReturnToNormalStatus" minOccurs="0"/>
 *         &lt;element name="spillageInformation" type="{http://datex2.eu/schema/2/2_0}SpillageInformation" minOccurs="0"/>
 *         &lt;element name="infrastructureDamage" type="{http://datex2.eu/schema/2/2_0}InfrastructureDamage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImpactDetails", propOrder = {
    "changeInCapacity",
    "increaseInDemand",
    "individualLanesStatus",
    "returnToNormalStatus",
    "spillageInformation",
    "infrastructureDamage"
})
public class ImpactDetails {

    protected Float changeInCapacity;
    protected BigInteger increaseInDemand;
    protected IndividualLanesStatus individualLanesStatus;
    protected ReturnToNormalStatus returnToNormalStatus;
    protected SpillageInformation spillageInformation;
    protected InfrastructureDamage infrastructureDamage;

    /**
     * Gets the value of the changeInCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getChangeInCapacity() {
        return changeInCapacity;
    }

    /**
     * Sets the value of the changeInCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setChangeInCapacity(Float value) {
        this.changeInCapacity = value;
    }

    /**
     * Gets the value of the increaseInDemand property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIncreaseInDemand() {
        return increaseInDemand;
    }

    /**
     * Sets the value of the increaseInDemand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIncreaseInDemand(BigInteger value) {
        this.increaseInDemand = value;
    }

    /**
     * Gets the value of the individualLanesStatus property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualLanesStatus }
     *     
     */
    public IndividualLanesStatus getIndividualLanesStatus() {
        return individualLanesStatus;
    }

    /**
     * Sets the value of the individualLanesStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualLanesStatus }
     *     
     */
    public void setIndividualLanesStatus(IndividualLanesStatus value) {
        this.individualLanesStatus = value;
    }

    /**
     * Gets the value of the returnToNormalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnToNormalStatus }
     *     
     */
    public ReturnToNormalStatus getReturnToNormalStatus() {
        return returnToNormalStatus;
    }

    /**
     * Sets the value of the returnToNormalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnToNormalStatus }
     *     
     */
    public void setReturnToNormalStatus(ReturnToNormalStatus value) {
        this.returnToNormalStatus = value;
    }

    /**
     * Gets the value of the spillageInformation property.
     * 
     * @return
     *     possible object is
     *     {@link SpillageInformation }
     *     
     */
    public SpillageInformation getSpillageInformation() {
        return spillageInformation;
    }

    /**
     * Sets the value of the spillageInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpillageInformation }
     *     
     */
    public void setSpillageInformation(SpillageInformation value) {
        this.spillageInformation = value;
    }

    /**
     * Gets the value of the infrastructureDamage property.
     * 
     * @return
     *     possible object is
     *     {@link InfrastructureDamage }
     *     
     */
    public InfrastructureDamage getInfrastructureDamage() {
        return infrastructureDamage;
    }

    /**
     * Sets the value of the infrastructureDamage property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfrastructureDamage }
     *     
     */
    public void setInfrastructureDamage(InfrastructureDamage value) {
        this.infrastructureDamage = value;
    }

}
