/**
 * Card.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class Card  implements java.io.Serializable {
    private com.pininteract.Pin[] pins;

    private int skuId;  // attribute

    private java.lang.String name;  // attribute

    private java.math.BigDecimal faceValue;  // attribute

    private java.lang.String instructions;  // attribute

    public Card() {
    }

    public Card(
           com.pininteract.Pin[] pins,
           int skuId,
           java.lang.String name,
           java.math.BigDecimal faceValue,
           java.lang.String instructions) {
           this.pins = pins;
           this.skuId = skuId;
           this.name = name;
           this.faceValue = faceValue;
           this.instructions = instructions;
    }


    /**
     * Gets the pins value for this Card.
     * 
     * @return pins
     */
    public com.pininteract.Pin[] getPins() {
        return pins;
    }


    /**
     * Sets the pins value for this Card.
     * 
     * @param pins
     */
    public void setPins(com.pininteract.Pin[] pins) {
        this.pins = pins;
    }


    /**
     * Gets the skuId value for this Card.
     * 
     * @return skuId
     */
    public int getSkuId() {
        return skuId;
    }


    /**
     * Sets the skuId value for this Card.
     * 
     * @param skuId
     */
    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }


    /**
     * Gets the name value for this Card.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Card.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the faceValue value for this Card.
     * 
     * @return faceValue
     */
    public java.math.BigDecimal getFaceValue() {
        return faceValue;
    }


    /**
     * Sets the faceValue value for this Card.
     * 
     * @param faceValue
     */
    public void setFaceValue(java.math.BigDecimal faceValue) {
        this.faceValue = faceValue;
    }


    /**
     * Gets the instructions value for this Card.
     * 
     * @return instructions
     */
    public java.lang.String getInstructions() {
        return instructions;
    }


    /**
     * Sets the instructions value for this Card.
     * 
     * @param instructions
     */
    public void setInstructions(java.lang.String instructions) {
        this.instructions = instructions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pins==null && other.getPins()==null) || 
             (this.pins!=null &&
              java.util.Arrays.equals(this.pins, other.getPins()))) &&
            this.skuId == other.getSkuId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.faceValue==null && other.getFaceValue()==null) || 
             (this.faceValue!=null &&
              this.faceValue.equals(other.getFaceValue()))) &&
            ((this.instructions==null && other.getInstructions()==null) || 
             (this.instructions!=null &&
              this.instructions.equals(other.getInstructions())));
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
        if (getPins() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPins());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPins(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getSkuId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getFaceValue() != null) {
            _hashCode += getFaceValue().hashCode();
        }
        if (getInstructions() != null) {
            _hashCode += getInstructions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Card.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Card"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("skuId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "skuId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("faceValue");
        attrField.setXmlName(new javax.xml.namespace.QName("", "faceValue"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("instructions");
        attrField.setXmlName(new javax.xml.namespace.QName("", "instructions"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pins");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "pins"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Pin"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:pininteract.com", "pin"));
        typeDesc.addFieldDesc(elemField);
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
