//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.07 at 06:00:18 PM CET 
//


package be.vdab.entities;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Boek complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Boek">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Titel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Schrijver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Uitgever" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Curriculums" type="{http://www.vdab.be/boeken}Curriculums"/>
 *       &lt;/sequence>
 *       &lt;attribute name="boeknr" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="isbn" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Boek", propOrder = {
    "titel",
    "schrijver",
    "uitgever",
    "curriculums"
})
public class Boek {

    @XmlElement(name = "Titel", required = true)
    protected String titel;
    @XmlElement(name = "Schrijver", required = true)
    protected String schrijver;
    @XmlElement(name = "Uitgever", required = true)
    protected String uitgever;
    @XmlElement(name = "Curriculums", required = true)
    protected Curriculums curriculums;
    @XmlAttribute(name = "boeknr")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger boeknr;
    @XmlAttribute(name = "isbn")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger isbn;

    /**
     * Gets the value of the titel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Sets the value of the titel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitel(String value) {
        this.titel = value;
    }

    /**
     * Gets the value of the schrijver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchrijver() {
        return schrijver;
    }

    /**
     * Sets the value of the schrijver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchrijver(String value) {
        this.schrijver = value;
    }

    /**
     * Gets the value of the uitgever property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUitgever() {
        return uitgever;
    }

    /**
     * Sets the value of the uitgever property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUitgever(String value) {
        this.uitgever = value;
    }

    /**
     * Gets the value of the curriculums property.
     * 
     * @return
     *     possible object is
     *     {@link Curriculums }
     *     
     */
    public Curriculums getCurriculums() {
        return curriculums;
    }

    /**
     * Sets the value of the curriculums property.
     * 
     * @param value
     *     allowed object is
     *     {@link Curriculums }
     *     
     */
    public void setCurriculums(Curriculums value) {
        this.curriculums = value;
    }

    /**
     * Gets the value of the boeknr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBoeknr() {
        return boeknr;
    }

    /**
     * Sets the value of the boeknr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBoeknr(BigInteger value) {
        this.boeknr = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIsbn(BigInteger value) {
        this.isbn = value;
    }

}