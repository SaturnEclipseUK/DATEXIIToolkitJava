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
import javax.xml.bind.annotation.XmlType;


/**
 * Extension class for Area.
 * 
 * <p>Java class for AreaExtension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AreaExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="geographicArea" type="{http://datex2.eu/schema/2/2_0}GeographicArea" minOccurs="0"/>
 *         &lt;element name="polygonArea" type="{http://datex2.eu/schema/2/2_0}PolygonArea" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AreaExtension", propOrder = {
    "geographicArea",
    "polygonArea"
})
public class AreaExtension {

    protected GeographicArea geographicArea;
    protected List<PolygonArea> polygonArea;

    /**
     * Gets the value of the geographicArea property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicArea }
     *     
     */
    public GeographicArea getGeographicArea() {
        return geographicArea;
    }

    /**
     * Sets the value of the geographicArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicArea }
     *     
     */
    public void setGeographicArea(GeographicArea value) {
        this.geographicArea = value;
    }

    /**
     * Gets the value of the polygonArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polygonArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolygonArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PolygonArea }
     * 
     * 
     */
    public List<PolygonArea> getPolygonArea() {
        if (polygonArea == null) {
            polygonArea = new ArrayList<PolygonArea>();
        }
        return this.polygonArea;
    }

}
