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
 * A cause of this situation record which is not managed by the publication creator, i.e. one which is not represented by another situation record produced by the same publication creator.
 * 
 * <p>Java class for NonManagedCause complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonManagedCause">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/2/2_0}Cause">
 *       &lt;sequence>
 *         &lt;element name="causeDescription" type="{http://datex2.eu/schema/2/2_0}MultilingualString" minOccurs="0"/>
 *         &lt;element name="causeType" type="{http://datex2.eu/schema/2/2_0}CauseTypeEnum" minOccurs="0"/>
 *         &lt;element name="nonManagedCauseExtension" type="{http://datex2.eu/schema/2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonManagedCause", propOrder = {
    "causeDescription",
    "causeType",
    "nonManagedCauseExtension"
})
public class NonManagedCause
    extends Cause
{

    protected MultilingualString causeDescription;
    protected CauseTypeEnum causeType;
    protected ExtensionType nonManagedCauseExtension;

    /**
     * Gets the value of the causeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualString }
     *     
     */
    public MultilingualString getCauseDescription() {
        return causeDescription;
    }

    /**
     * Sets the value of the causeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualString }
     *     
     */
    public void setCauseDescription(MultilingualString value) {
        this.causeDescription = value;
    }

    /**
     * Gets the value of the causeType property.
     * 
     * @return
     *     possible object is
     *     {@link CauseTypeEnum }
     *     
     */
    public CauseTypeEnum getCauseType() {
        return causeType;
    }

    /**
     * Sets the value of the causeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CauseTypeEnum }
     *     
     */
    public void setCauseType(CauseTypeEnum value) {
        this.causeType = value;
    }

    /**
     * Gets the value of the nonManagedCauseExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getNonManagedCauseExtension() {
        return nonManagedCauseExtension;
    }

    /**
     * Sets the value of the nonManagedCauseExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setNonManagedCauseExtension(ExtensionType value) {
        this.nonManagedCauseExtension = value;
    }

}
