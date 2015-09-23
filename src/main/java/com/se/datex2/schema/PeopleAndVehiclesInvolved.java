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
 * Contains information related to the people and vehicles involved in a situation/event.  The container uses standard DATEXII types only available to Accident SituationRecords, to enable other types of SituationRecord to access these items.
 * 
 * <p>Java class for PeopleAndVehiclesInvolved complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeopleAndVehiclesInvolved">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalNumberOfPeopleInvolved" type="{http://datex2.eu/schema/2/2_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="totalNumberOfVehiclesInvolved" type="{http://datex2.eu/schema/2/2_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="groupOfVehiclesInvolved" type="{http://datex2.eu/schema/2/2_0}GroupOfVehiclesInvolved" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="groupOfPeopleInvolved" type="{http://datex2.eu/schema/2/2_0}GroupOfPeopleInvolved" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="peopleAndVehiclesInvolvedExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeopleAndVehiclesInvolved", propOrder = {
    "totalNumberOfPeopleInvolved",
    "totalNumberOfVehiclesInvolved",
    "groupOfVehiclesInvolved",
    "groupOfPeopleInvolved",
    "peopleAndVehiclesInvolvedExtension"
})
public class PeopleAndVehiclesInvolved {

    protected BigInteger totalNumberOfPeopleInvolved;
    protected BigInteger totalNumberOfVehiclesInvolved;
    protected List<GroupOfVehiclesInvolved> groupOfVehiclesInvolved;
    protected List<GroupOfPeopleInvolved> groupOfPeopleInvolved;
    protected ExtensionType peopleAndVehiclesInvolvedExtension;

    /**
     * Gets the value of the totalNumberOfPeopleInvolved property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalNumberOfPeopleInvolved() {
        return totalNumberOfPeopleInvolved;
    }

    /**
     * Sets the value of the totalNumberOfPeopleInvolved property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalNumberOfPeopleInvolved(BigInteger value) {
        this.totalNumberOfPeopleInvolved = value;
    }

    /**
     * Gets the value of the totalNumberOfVehiclesInvolved property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalNumberOfVehiclesInvolved() {
        return totalNumberOfVehiclesInvolved;
    }

    /**
     * Sets the value of the totalNumberOfVehiclesInvolved property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalNumberOfVehiclesInvolved(BigInteger value) {
        this.totalNumberOfVehiclesInvolved = value;
    }

    /**
     * Gets the value of the groupOfVehiclesInvolved property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupOfVehiclesInvolved property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupOfVehiclesInvolved().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupOfVehiclesInvolved }
     * 
     * 
     */
    public List<GroupOfVehiclesInvolved> getGroupOfVehiclesInvolved() {
        if (groupOfVehiclesInvolved == null) {
            groupOfVehiclesInvolved = new ArrayList<GroupOfVehiclesInvolved>();
        }
        return this.groupOfVehiclesInvolved;
    }

    /**
     * Gets the value of the groupOfPeopleInvolved property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupOfPeopleInvolved property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupOfPeopleInvolved().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupOfPeopleInvolved }
     * 
     * 
     */
    public List<GroupOfPeopleInvolved> getGroupOfPeopleInvolved() {
        if (groupOfPeopleInvolved == null) {
            groupOfPeopleInvolved = new ArrayList<GroupOfPeopleInvolved>();
        }
        return this.groupOfPeopleInvolved;
    }

    /**
     * Gets the value of the peopleAndVehiclesInvolvedExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getPeopleAndVehiclesInvolvedExtension() {
        return peopleAndVehiclesInvolvedExtension;
    }

    /**
     * Sets the value of the peopleAndVehiclesInvolvedExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setPeopleAndVehiclesInvolvedExtension(ExtensionType value) {
        this.peopleAndVehiclesInvolvedExtension = value;
    }

}
