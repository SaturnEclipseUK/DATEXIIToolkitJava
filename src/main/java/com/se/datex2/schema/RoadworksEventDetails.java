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
 * Additional details of a Roadworks Event.
 * 
 * <p>Java class for RoadworksEventDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoadworksEventDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roadworksSchemeName" type="{http://datex2.eu/schema/2/2_0}String" minOccurs="0"/>
 *         &lt;element name="situationParent" type="{http://datex2.eu/schema/2/2_0}SituationParent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoadworksEventDetails", propOrder = {
    "roadworksSchemeName",
    "situationParent"
})
public class RoadworksEventDetails {

    protected String roadworksSchemeName;
    protected SituationParent situationParent;

    /**
     * Gets the value of the roadworksSchemeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoadworksSchemeName() {
        return roadworksSchemeName;
    }

    /**
     * Sets the value of the roadworksSchemeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoadworksSchemeName(String value) {
        this.roadworksSchemeName = value;
    }

    /**
     * Gets the value of the situationParent property.
     * 
     * @return
     *     possible object is
     *     {@link SituationParent }
     *     
     */
    public SituationParent getSituationParent() {
        return situationParent;
    }

    /**
     * Sets the value of the situationParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationParent }
     *     
     */
    public void setSituationParent(SituationParent value) {
        this.situationParent = value;
    }

}
