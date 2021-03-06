//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.23 at 07:04:22 PM CET 
//


package com.reseration.xml;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_reservation" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="id_client" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="id_train" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idReservation",
    "idClient",
    "idTrain"
})
@XmlRootElement(name = "UpdateReservationRequest")
public class UpdateReservationRequest {

    @XmlElement(name = "id_reservation", required = true)
    protected BigInteger idReservation;
    @XmlElement(name = "id_client", required = true)
    protected BigInteger idClient;
    @XmlElement(name = "id_train", required = true)
    protected BigInteger idTrain;

    /**
     * Gets the value of the idReservation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdReservation() {
        return idReservation;
    }

    /**
     * Sets the value of the idReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdReservation(BigInteger value) {
        this.idReservation = value;
    }

    /**
     * Gets the value of the idClient property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdClient() {
        return idClient;
    }

    /**
     * Sets the value of the idClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdClient(BigInteger value) {
        this.idClient = value;
    }

    /**
     * Gets the value of the idTrain property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdTrain() {
        return idTrain;
    }

    /**
     * Sets the value of the idTrain property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdTrain(BigInteger value) {
        this.idTrain = value;
    }

}
