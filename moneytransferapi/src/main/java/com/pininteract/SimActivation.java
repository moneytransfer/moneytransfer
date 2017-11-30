/**
 * SimActivation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class SimActivation  implements java.io.Serializable {
    private java.lang.String simNumber;  // attribute

    private java.lang.String zipCode;  // attribute

    private java.lang.String language;  // attribute

    private java.lang.String mobileNumber;  // attribute

    private java.lang.String donorOperatorCode;  // attribute

    private java.lang.String donorOperatorName;  // attribute

    private java.lang.String accountNumber;  // attribute

    public SimActivation() {
    }

    public SimActivation(
           java.lang.String simNumber,
           java.lang.String zipCode,
           java.lang.String language,
           java.lang.String mobileNumber,
           java.lang.String donorOperatorCode,
           java.lang.String donorOperatorName,
           java.lang.String accountNumber) {
           this.simNumber = simNumber;
           this.zipCode = zipCode;
           this.language = language;
           this.mobileNumber = mobileNumber;
           this.donorOperatorCode = donorOperatorCode;
           this.donorOperatorName = donorOperatorName;
           this.accountNumber = accountNumber;
    }


    /**
     * Gets the simNumber value for this SimActivation.
     * 
     * @return simNumber
     */
    public java.lang.String getSimNumber() {
        return simNumber;
    }


    /**
     * Sets the simNumber value for this SimActivation.
     * 
     * @param simNumber
     */
    public void setSimNumber(java.lang.String simNumber) {
        this.simNumber = simNumber;
    }


    /**
     * Gets the zipCode value for this SimActivation.
     * 
     * @return zipCode
     */
    public java.lang.String getZipCode() {
        return zipCode;
    }


    /**
     * Sets the zipCode value for this SimActivation.
     * 
     * @param zipCode
     */
    public void setZipCode(java.lang.String zipCode) {
        this.zipCode = zipCode;
    }


    /**
     * Gets the language value for this SimActivation.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this SimActivation.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the mobileNumber value for this SimActivation.
     * 
     * @return mobileNumber
     */
    public java.lang.String getMobileNumber() {
        return mobileNumber;
    }


    /**
     * Sets the mobileNumber value for this SimActivation.
     * 
     * @param mobileNumber
     */
    public void setMobileNumber(java.lang.String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    /**
     * Gets the donorOperatorCode value for this SimActivation.
     * 
     * @return donorOperatorCode
     */
    public java.lang.String getDonorOperatorCode() {
        return donorOperatorCode;
    }


    /**
     * Sets the donorOperatorCode value for this SimActivation.
     * 
     * @param donorOperatorCode
     */
    public void setDonorOperatorCode(java.lang.String donorOperatorCode) {
        this.donorOperatorCode = donorOperatorCode;
    }


    /**
     * Gets the donorOperatorName value for this SimActivation.
     * 
     * @return donorOperatorName
     */
    public java.lang.String getDonorOperatorName() {
        return donorOperatorName;
    }


    /**
     * Sets the donorOperatorName value for this SimActivation.
     * 
     * @param donorOperatorName
     */
    public void setDonorOperatorName(java.lang.String donorOperatorName) {
        this.donorOperatorName = donorOperatorName;
    }


    /**
     * Gets the accountNumber value for this SimActivation.
     * 
     * @return accountNumber
     */
    public java.lang.String getAccountNumber() {
        return accountNumber;
    }


    /**
     * Sets the accountNumber value for this SimActivation.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimActivation)) return false;
        SimActivation other = (SimActivation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.simNumber==null && other.getSimNumber()==null) || 
             (this.simNumber!=null &&
              this.simNumber.equals(other.getSimNumber()))) &&
            ((this.zipCode==null && other.getZipCode()==null) || 
             (this.zipCode!=null &&
              this.zipCode.equals(other.getZipCode()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.mobileNumber==null && other.getMobileNumber()==null) || 
             (this.mobileNumber!=null &&
              this.mobileNumber.equals(other.getMobileNumber()))) &&
            ((this.donorOperatorCode==null && other.getDonorOperatorCode()==null) || 
             (this.donorOperatorCode!=null &&
              this.donorOperatorCode.equals(other.getDonorOperatorCode()))) &&
            ((this.donorOperatorName==null && other.getDonorOperatorName()==null) || 
             (this.donorOperatorName!=null &&
              this.donorOperatorName.equals(other.getDonorOperatorName()))) &&
            ((this.accountNumber==null && other.getAccountNumber()==null) || 
             (this.accountNumber!=null &&
              this.accountNumber.equals(other.getAccountNumber())));
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
        if (getSimNumber() != null) {
            _hashCode += getSimNumber().hashCode();
        }
        if (getZipCode() != null) {
            _hashCode += getZipCode().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getMobileNumber() != null) {
            _hashCode += getMobileNumber().hashCode();
        }
        if (getDonorOperatorCode() != null) {
            _hashCode += getDonorOperatorCode().hashCode();
        }
        if (getDonorOperatorName() != null) {
            _hashCode += getDonorOperatorName().hashCode();
        }
        if (getAccountNumber() != null) {
            _hashCode += getAccountNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimActivation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "SimActivation"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("simNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "simNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("zipCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "zipCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language");
        attrField.setXmlName(new javax.xml.namespace.QName("", "language"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mobileNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mobileNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("donorOperatorCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "donorOperatorCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("donorOperatorName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "donorOperatorName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("accountNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "accountNumber"));
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
