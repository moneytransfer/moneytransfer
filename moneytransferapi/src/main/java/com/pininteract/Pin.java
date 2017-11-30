/**
 * Pin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class Pin  implements java.io.Serializable {
    private java.lang.String pinNumber;  // attribute

    private java.lang.String controlNumber;  // attribute

    public Pin() {
    }

    public Pin(
           java.lang.String pinNumber,
           java.lang.String controlNumber) {
           this.pinNumber = pinNumber;
           this.controlNumber = controlNumber;
    }


    /**
     * Gets the pinNumber value for this Pin.
     * 
     * @return pinNumber
     */
    public java.lang.String getPinNumber() {
        return pinNumber;
    }


    /**
     * Sets the pinNumber value for this Pin.
     * 
     * @param pinNumber
     */
    public void setPinNumber(java.lang.String pinNumber) {
        this.pinNumber = pinNumber;
    }


    /**
     * Gets the controlNumber value for this Pin.
     * 
     * @return controlNumber
     */
    public java.lang.String getControlNumber() {
        return controlNumber;
    }


    /**
     * Sets the controlNumber value for this Pin.
     * 
     * @param controlNumber
     */
    public void setControlNumber(java.lang.String controlNumber) {
        this.controlNumber = controlNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pin)) return false;
        Pin other = (Pin) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pinNumber==null && other.getPinNumber()==null) || 
             (this.pinNumber!=null &&
              this.pinNumber.equals(other.getPinNumber()))) &&
            ((this.controlNumber==null && other.getControlNumber()==null) || 
             (this.controlNumber!=null &&
              this.controlNumber.equals(other.getControlNumber())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPinNumber() != null) {
            _hashCode += getPinNumber().hashCode();
        }
        if (getControlNumber() != null) {
            _hashCode += getControlNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pin.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Pin"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pinNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pinNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("controlNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "controlNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
