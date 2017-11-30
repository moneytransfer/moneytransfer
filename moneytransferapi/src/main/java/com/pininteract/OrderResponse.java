/**
 * OrderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class OrderResponse  implements java.io.Serializable {
    private com.pininteract.Invoice invoice;

    private com.pininteract.TopUp topUp;

    private com.pininteract.SimActivation simActivation;

    private java.lang.String version;  // attribute

    private java.lang.String responseCode;  // attribute

    private java.lang.String responseMessage;  // attribute

    public OrderResponse() {
    }

    public OrderResponse(
           com.pininteract.Invoice invoice,
           com.pininteract.TopUp topUp,
           com.pininteract.SimActivation simActivation,
           java.lang.String version,
           java.lang.String responseCode,
           java.lang.String responseMessage) {
           this.invoice = invoice;
           this.topUp = topUp;
           this.simActivation = simActivation;
           this.version = version;
           this.responseCode = responseCode;
           this.responseMessage = responseMessage;
    }


    /**
     * Gets the invoice value for this OrderResponse.
     * 
     * @return invoice
     */
    public com.pininteract.Invoice getInvoice() {
        return invoice;
    }


    /**
     * Sets the invoice value for this OrderResponse.
     * 
     * @param invoice
     */
    public void setInvoice(com.pininteract.Invoice invoice) {
        this.invoice = invoice;
    }


    /**
     * Gets the topUp value for this OrderResponse.
     * 
     * @return topUp
     */
    public com.pininteract.TopUp getTopUp() {
        return topUp;
    }


    /**
     * Sets the topUp value for this OrderResponse.
     * 
     * @param topUp
     */
    public void setTopUp(com.pininteract.TopUp topUp) {
        this.topUp = topUp;
    }


    /**
     * Gets the simActivation value for this OrderResponse.
     * 
     * @return simActivation
     */
    public com.pininteract.SimActivation getSimActivation() {
        return simActivation;
    }


    /**
     * Sets the simActivation value for this OrderResponse.
     * 
     * @param simActivation
     */
    public void setSimActivation(com.pininteract.SimActivation simActivation) {
        this.simActivation = simActivation;
    }


    /**
     * Gets the version value for this OrderResponse.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this OrderResponse.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the responseCode value for this OrderResponse.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this OrderResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the responseMessage value for this OrderResponse.
     * 
     * @return responseMessage
     */
    public java.lang.String getResponseMessage() {
        return responseMessage;
    }


    /**
     * Sets the responseMessage value for this OrderResponse.
     * 
     * @param responseMessage
     */
    public void setResponseMessage(java.lang.String responseMessage) {
        this.responseMessage = responseMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrderResponse)) return false;
        OrderResponse other = (OrderResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.invoice==null && other.getInvoice()==null) || 
             (this.invoice!=null &&
              this.invoice.equals(other.getInvoice()))) &&
            ((this.topUp==null && other.getTopUp()==null) || 
             (this.topUp!=null &&
              this.topUp.equals(other.getTopUp()))) &&
            ((this.simActivation==null && other.getSimActivation()==null) || 
             (this.simActivation!=null &&
              this.simActivation.equals(other.getSimActivation()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.responseMessage==null && other.getResponseMessage()==null) || 
             (this.responseMessage!=null &&
              this.responseMessage.equals(other.getResponseMessage())));
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
        if (getInvoice() != null) {
            _hashCode += getInvoice().hashCode();
        }
        if (getTopUp() != null) {
            _hashCode += getTopUp().hashCode();
        }
        if (getSimActivation() != null) {
            _hashCode += getSimActivation().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getResponseMessage() != null) {
            _hashCode += getResponseMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "OrderResponse"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("version");
        attrField.setXmlName(new javax.xml.namespace.QName("", "version"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("responseCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("responseMessage");
        attrField.setXmlName(new javax.xml.namespace.QName("", "responseMessage"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoice");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "invoice"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Invoice"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topUp");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "topUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "TopUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simActivation");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "simActivation"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "SimActivation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
