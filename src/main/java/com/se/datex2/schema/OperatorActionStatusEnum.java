//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 08:20:34 AM BST 
//


package com.se.datex2.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperatorActionStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatorActionStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="requested"/>
 *     &lt;enumeration value="approved"/>
 *     &lt;enumeration value="beingImplemented"/>
 *     &lt;enumeration value="implemented"/>
 *     &lt;enumeration value="rejected"/>
 *     &lt;enumeration value="terminationRequested"/>
 *     &lt;enumeration value="beingTerminated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperatorActionStatusEnum")
@XmlEnum
public enum OperatorActionStatusEnum {


    /**
     * A request, either internal or external, has been received to implement an action. It has neither been approved nor has any activity yet been undertaken to implement the action.
     * 
     */
    @XmlEnumValue("requested")
    REQUESTED("requested"),

    /**
     * The action has been approved by the recipient of the request but activity to implement the action has not yet commenced.
     * 
     */
    @XmlEnumValue("approved")
    APPROVED("approved"),

    /**
     * The action is in the process of being implemented.
     * 
     */
    @XmlEnumValue("beingImplemented")
    BEING_IMPLEMENTED("beingImplemented"),

    /**
     * The action is fully implemented.
     * 
     */
    @XmlEnumValue("implemented")
    IMPLEMENTED("implemented"),

    /**
     * The action has been rejected by the recipient of the request and hence is not implemented.
     * 
     */
    @XmlEnumValue("rejected")
    REJECTED("rejected"),

    /**
     * A request, either internal or external, has been received to terminate the action, but activity to terminate the action has not yet commenced.
     * 
     */
    @XmlEnumValue("terminationRequested")
    TERMINATION_REQUESTED("terminationRequested"),

    /**
     * The action is in the process of being terminated either because the action has reached the end of its validity period or because new circumstances have arisen and its termination has been requested, e.g. because of a traffic jam on the alternative route.
     * 
     */
    @XmlEnumValue("beingTerminated")
    BEING_TERMINATED("beingTerminated");
    private final String value;

    OperatorActionStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatorActionStatusEnum fromValue(String v) {
        for (OperatorActionStatusEnum c: OperatorActionStatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
