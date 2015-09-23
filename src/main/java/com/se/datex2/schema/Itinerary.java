//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Multiple (i.e. more than one) physically separate locations arranged as an ordered set that defines an itinerary or route.
 * 
 * <p>Java class for Itinerary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Itinerary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/2/2_0}GroupOfLocations">
 *       &lt;sequence>
 *         &lt;element name="routeDestination" type="{http://datex2.eu/schema/2/2_0}Destination" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="itineraryExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Itinerary", propOrder = {
    "routeDestination",
    "itineraryExtension"
})
@XmlSeeAlso({
    ItineraryByReference.class,
    ItineraryByIndexedLocations.class
})
public abstract class Itinerary
    extends GroupOfLocations
{

    protected List<Destination> routeDestination;
    protected ExtensionType itineraryExtension;

    /**
     * Gets the value of the routeDestination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routeDestination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRouteDestination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Destination }
     * 
     * 
     */
    public List<Destination> getRouteDestination() {
        if (routeDestination == null) {
            routeDestination = new ArrayList<Destination>();
        }
        return this.routeDestination;
    }

    /**
     * Gets the value of the itineraryExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getItineraryExtension() {
        return itineraryExtension;
    }

    /**
     * Sets the value of the itineraryExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setItineraryExtension(ExtensionType value) {
        this.itineraryExtension = value;
    }

}
