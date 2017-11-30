/**
 * ExchangeRateInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract.www;

public class ExchangeRateInfo  implements java.io.Serializable {
    private int skuId;

    private java.lang.String skuName;

    private java.lang.String currencyCode;

    private java.math.BigDecimal exchangeRate;

    private java.math.BigDecimal bonusAmount;

    public ExchangeRateInfo() {
    }

    public ExchangeRateInfo(
           int skuId,
           java.lang.String skuName,
           java.lang.String currencyCode,
           java.math.BigDecimal exchangeRate,
           java.math.BigDecimal bonusAmount) {
           this.skuId = skuId;
           this.skuName = skuName;
           this.currencyCode = currencyCode;
           this.exchangeRate = exchangeRate;
           this.bonusAmount = bonusAmount;
    }


    /**
     * Gets the skuId value for this ExchangeRateInfo.
     * 
     * @return skuId
     */
    public int getSkuId() {
        return skuId;
    }


    /**
     * Sets the skuId value for this ExchangeRateInfo.
     * 
     * @param skuId
     */
    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }


    /**
     * Gets the skuName value for this ExchangeRateInfo.
     * 
     * @return skuName
     */
    public java.lang.String getSkuName() {
        return skuName;
    }


    /**
     * Sets the skuName value for this ExchangeRateInfo.
     * 
     * @param skuName
     */
    public void setSkuName(java.lang.String skuName) {
        this.skuName = skuName;
    }


    /**
     * Gets the currencyCode value for this ExchangeRateInfo.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this ExchangeRateInfo.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the exchangeRate value for this ExchangeRateInfo.
     * 
     * @return exchangeRate
     */
    public java.math.BigDecimal getExchangeRate() {
        return exchangeRate;
    }


    /**
     * Sets the exchangeRate value for this ExchangeRateInfo.
     * 
     * @param exchangeRate
     */
    public void setExchangeRate(java.math.BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }


    /**
     * Gets the bonusAmount value for this ExchangeRateInfo.
     * 
     * @return bonusAmount
     */
    public java.math.BigDecimal getBonusAmount() {
        return bonusAmount;
    }


    /**
     * Sets the bonusAmount value for this ExchangeRateInfo.
     * 
     * @param bonusAmount
     */
    public void setBonusAmount(java.math.BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExchangeRateInfo)) return false;
        ExchangeRateInfo other = (ExchangeRateInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.skuId == other.getSkuId() &&
            ((this.skuName==null && other.getSkuName()==null) || 
             (this.skuName!=null &&
              this.skuName.equals(other.getSkuName()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.exchangeRate==null && other.getExchangeRate()==null) || 
             (this.exchangeRate!=null &&
              this.exchangeRate.equals(other.getExchangeRate()))) &&
            ((this.bonusAmount==null && other.getBonusAmount()==null) || 
             (this.bonusAmount!=null &&
              this.bonusAmount.equals(other.getBonusAmount())));
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
        _hashCode += getSkuId();
        if (getSkuName() != null) {
            _hashCode += getSkuName().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getExchangeRate() != null) {
            _hashCode += getExchangeRate().hashCode();
        }
        if (getBonusAmount() != null) {
            _hashCode += getBonusAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExchangeRateInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.pininteract.com", "ExchangeRateInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skuId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "SkuId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skuName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "SkuName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "CurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exchangeRate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "ExchangeRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bonusAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "BonusAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
