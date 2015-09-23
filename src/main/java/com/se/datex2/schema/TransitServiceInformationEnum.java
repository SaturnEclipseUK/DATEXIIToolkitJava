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
 * <p>Java class for TransitServiceInformationEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransitServiceInformationEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cancellations"/>
 *     &lt;enumeration value="delayDueToBadWeather"/>
 *     &lt;enumeration value="delayDueToRepairs"/>
 *     &lt;enumeration value="delayedUntilFurtherNotice"/>
 *     &lt;enumeration value="delaysDueToFlotsam"/>
 *     &lt;enumeration value="departureOnSchedule"/>
 *     &lt;enumeration value="ferryReplacedByIceRoad"/>
 *     &lt;enumeration value="freeShuttleServiceOperating"/>
 *     &lt;enumeration value="informationServiceNotAvailable"/>
 *     &lt;enumeration value="irregularServiceDelays"/>
 *     &lt;enumeration value="loadCapacityChanged"/>
 *     &lt;enumeration value="restrictionsForLongerVehicles"/>
 *     &lt;enumeration value="serviceDelays"/>
 *     &lt;enumeration value="serviceDelaysOfUncertainDuration"/>
 *     &lt;enumeration value="serviceFullyBooked"/>
 *     &lt;enumeration value="serviceNotOperating"/>
 *     &lt;enumeration value="serviceNotOperatingSubstituteServiceAvailable"/>
 *     &lt;enumeration value="serviceSuspended"/>
 *     &lt;enumeration value="serviceWithdrawn"/>
 *     &lt;enumeration value="shuttleServiceOperating"/>
 *     &lt;enumeration value="temporaryChangesToTimetables"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransitServiceInformationEnum")
@XmlEnum
public enum TransitServiceInformationEnum {


    /**
     * Public transport, park-and-ride, rail or bus services will be cancelled until the specified time.
     * 
     */
    @XmlEnumValue("cancellations")
    CANCELLATIONS("cancellations"),

    /**
     * The specified service is delayed due to bad weather.
     * 
     */
    @XmlEnumValue("delayDueToBadWeather")
    DELAY_DUE_TO_BAD_WEATHER("delayDueToBadWeather"),

    /**
     * The specified service is delayed due to the need for repairs.
     * 
     */
    @XmlEnumValue("delayDueToRepairs")
    DELAY_DUE_TO_REPAIRS("delayDueToRepairs"),

    /**
     * The specified public transport service will be delayed until further notice.
     * 
     */
    @XmlEnumValue("delayedUntilFurtherNotice")
    DELAYED_UNTIL_FURTHER_NOTICE("delayedUntilFurtherNotice"),

    /**
     * The departure of the specified ferry service is delayed due to flotsam.
     * 
     */
    @XmlEnumValue("delaysDueToFlotsam")
    DELAYS_DUE_TO_FLOTSAM("delaysDueToFlotsam"),

    /**
     * The departure of the specified service is on schedule.
     * 
     */
    @XmlEnumValue("departureOnSchedule")
    DEPARTURE_ON_SCHEDULE("departureOnSchedule"),

    /**
     * The ferry service has been replaced by an ice road.
     * 
     */
    @XmlEnumValue("ferryReplacedByIceRoad")
    FERRY_REPLACED_BY_ICE_ROAD("ferryReplacedByIceRoad"),

    /**
     * A shuttle service is operating at no charge between specified locations until the specified time.
     * 
     */
    @XmlEnumValue("freeShuttleServiceOperating")
    FREE_SHUTTLE_SERVICE_OPERATING("freeShuttleServiceOperating"),

    /**
     * The information service relating to the specified transport system is not currently available.
     * 
     */
    @XmlEnumValue("informationServiceNotAvailable")
    INFORMATION_SERVICE_NOT_AVAILABLE("informationServiceNotAvailable"),

    /**
     * The specified service is subject to irregular delays.
     * 
     */
    @XmlEnumValue("irregularServiceDelays")
    IRREGULAR_SERVICE_DELAYS("irregularServiceDelays"),

    /**
     * The load capacity for the specified service has been changed.
     * 
     */
    @XmlEnumValue("loadCapacityChanged")
    LOAD_CAPACITY_CHANGED("loadCapacityChanged"),

    /**
     * Long vehicles are subject to restrictions on the specified service.
     * 
     */
    @XmlEnumValue("restrictionsForLongerVehicles")
    RESTRICTIONS_FOR_LONGER_VEHICLES("restrictionsForLongerVehicles"),

    /**
     * The specified service is subject to delays.
     * 
     */
    @XmlEnumValue("serviceDelays")
    SERVICE_DELAYS("serviceDelays"),

    /**
     * The specified service is subject to delays whose predicted duration cannot be estimated accurately.
     * 
     */
    @XmlEnumValue("serviceDelaysOfUncertainDuration")
    SERVICE_DELAYS_OF_UNCERTAIN_DURATION("serviceDelaysOfUncertainDuration"),

    /**
     * The departure of the specified service is fully booked.
     * 
     */
    @XmlEnumValue("serviceFullyBooked")
    SERVICE_FULLY_BOOKED("serviceFullyBooked"),

    /**
     * The specified service is not operating until the specified time.
     * 
     */
    @XmlEnumValue("serviceNotOperating")
    SERVICE_NOT_OPERATING("serviceNotOperating"),

    /**
     * The specified service is not operating but an alternative service is available.
     * 
     */
    @XmlEnumValue("serviceNotOperatingSubstituteServiceAvailable")
    SERVICE_NOT_OPERATING_SUBSTITUTE_SERVICE_AVAILABLE("serviceNotOperatingSubstituteServiceAvailable"),

    /**
     * The specified service has been suspended until the specified time.
     * 
     */
    @XmlEnumValue("serviceSuspended")
    SERVICE_SUSPENDED("serviceSuspended"),

    /**
     * The specified service has been cancelled.
     * 
     */
    @XmlEnumValue("serviceWithdrawn")
    SERVICE_WITHDRAWN("serviceWithdrawn"),

    /**
     * A shuttle service is operating between the specified locations until the specified time.
     * 
     */
    @XmlEnumValue("shuttleServiceOperating")
    SHUTTLE_SERVICE_OPERATING("shuttleServiceOperating"),

    /**
     * The timetable for the specified service is subject to temporary changes.
     * 
     */
    @XmlEnumValue("temporaryChangesToTimetables")
    TEMPORARY_CHANGES_TO_TIMETABLES("temporaryChangesToTimetables"),

    /**
     * Other than as defined in this enumeration.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    TransitServiceInformationEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransitServiceInformationEnum fromValue(String v) {
        for (TransitServiceInformationEnum c: TransitServiceInformationEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
