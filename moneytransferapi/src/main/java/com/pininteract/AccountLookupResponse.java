/**
 * AccountLookupResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class AccountLookupResponse  implements java.io.Serializable {
    private com.pininteract.AccountInfo[] accountInfos;

    private java.lang.String version;  // attribute

    private java.lang.String responseCode;  // attribute

    private java.lang.String responseMessage;  // attribute

    public AccountLookupResponse() {
    }

    public AccountLookupResponse(
           com.pininteract.AccountInfo[] accountInfos,
           java.lang.String version,
           java.lang.String responseCode,
           java.lang.String responseMessage) {
           this.accountInfos = accountInfos;
           this.version = version;
           this.responseCode = responseCode;
           this.responseMessage = responseMessage;
    }


    /**
     * Gets the accountInfos value for this AccountLookupResponse.
     * 
     * @return accountInfos
     */
    public com.pininteract.AccountInfo[] getAccountInfos() {
        return accountInfos;
    }


    /**
     * Sets the accountInfos value for this AccountLookupResponse.
     * 
     * @param accountInfos
     */
    public void setAccountInfos(com.pininteract.AccountInfo[] accountInfos) {
        this.accountInfos = accountInfos;
    }


    /**
     * Gets the version value for this AccountLookupResponse.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this AccountLookupResponse.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the responseCode value for this AccountLookupResponse.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this AccountLookupResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the responseMessage value for this AccountLookupResponse.
     * 
     * @return responseMessage
     */
    public java.lang.String getResponseMessage() {
        return responseMessage;
    }


    /**
     * Sets the responseMessage value for this AccountLookupResponse.
     * 
     * @param responseMessage
     */
    public void setResponseMessage(java.lang.String responseMessage) {
        this.responseMessage = responseMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountLookupResponse)) return false;
        AccountLookupResponse other = (AccountLookupResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountInfos==null && other.getAccountInfos()==null) || 
             (this.accountInfos!=null &&
              java.util.Arrays.equals(this.accountInfos, other.getAccountInfos()))) &&
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
        if (getAccountInfos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountInfos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountInfos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(AccountLookupResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "AccountLookupResponse"));
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
        elemField.setFieldName("accountInfos");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "accountInfos"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "AccountInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:pininteract.com", "accountInfo"));
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
