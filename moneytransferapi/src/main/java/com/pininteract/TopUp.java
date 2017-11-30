/**
 * TopUp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class TopUp  implements java.io.Serializable {
    private java.math.BigDecimal localCurrencyAmount;  // attribute

    private java.math.BigDecimal salesTaxAmount;  // attribute

    private java.math.BigDecimal localCurrencyAmountExcludingTax;  // attribute

    private java.lang.String localCurrencyName;  // attribute

    private java.lang.String newAccountBalance;  // attribute

    private java.lang.String operatorTransactionId;  // attribute

    public TopUp() {
    }

    public TopUp(
           java.math.BigDecimal localCurrencyAmount,
           java.math.BigDecimal salesTaxAmount,
           java.math.BigDecimal localCurrencyAmountExcludingTax,
           java.lang.String localCurrencyName,
           java.lang.String newAccountBalance,
           java.lang.String operatorTransactionId) {
           this.localCurrencyAmount = localCurrencyAmount;
           this.salesTaxAmount = salesTaxAmount;
           this.localCurrencyAmountExcludingTax = localCurrencyAmountExcludingTax;
           this.localCurrencyName = localCurrencyName;
           this.newAccountBalance = newAccountBalance;
           this.operatorTransactionId = operatorTransactionId;
    }


    /**
     * Gets the localCurrencyAmount value for this TopUp.
     * 
     * @return localCurrencyAmount
     */
    public java.math.BigDecimal getLocalCurrencyAmount() {
        return localCurrencyAmount;
    }


    /**
     * Sets the localCurrencyAmount value for this TopUp.
     * 
     * @param localCurrencyAmount
     */
    public void setLocalCurrencyAmount(java.math.BigDecimal localCurrencyAmount) {
        this.localCurrencyAmount = localCurrencyAmount;
    }


    /**
     * Gets the salesTaxAmount value for this TopUp.
     * 
     * @return salesTaxAmount
     */
    public java.math.BigDecimal getSalesTaxAmount() {
        return salesTaxAmount;
    }


    /**
     * Sets the salesTaxAmount value for this TopUp.
     * 
     * @param salesTaxAmount
     */
    public void setSalesTaxAmount(java.math.BigDecimal salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }


    /**
     * Gets the localCurrencyAmountExcludingTax value for this TopUp.
     * 
     * @return localCurrencyAmountExcludingTax
     */
    public java.math.BigDecimal getLocalCurrencyAmountExcludingTax() {
        return localCurrencyAmountExcludingTax;
    }


    /**
     * Sets the localCurrencyAmountExcludingTax value for this TopUp.
     * 
     * @param localCurrencyAmountExcludingTax
     */
    public void setLocalCurrencyAmountExcludingTax(java.math.BigDecimal localCurrencyAmountExcludingTax) {
        this.localCurrencyAmountExcludingTax = localCurrencyAmountExcludingTax;
    }


    /**
     * Gets the localCurrencyName value for this TopUp.
     * 
     * @return localCurrencyName
     */
    public java.lang.String getLocalCurrencyName() {
        return localCurrencyName;
    }


    /**
     * Sets the localCurrencyName value for this TopUp.
     * 
     * @param localCurrencyName
     */
    public void setLocalCurrencyName(java.lang.String localCurrencyName) {
        this.localCurrencyName = localCurrencyName;
    }


    /**
     * Gets the newAccountBalance value for this TopUp.
     * 
     * @return newAccountBalance
     */
    public java.lang.String getNewAccountBalance() {
        return newAccountBalance;
    }


    /**
     * Sets the newAccountBalance value for this TopUp.
     * 
     * @param newAccountBalance
     */
    public void setNewAccountBalance(java.lang.String newAccountBalance) {
        this.newAccountBalance = newAccountBalance;
    }


    /**
     * Gets the operatorTransactionId value for this TopUp.
     * 
     * @return operatorTransactionId
     */
    public java.lang.String getOperatorTransactionId() {
        return operatorTransactionId;
    }


    /**
     * Sets the operatorTransactionId value for this TopUp.
     * 
     * @param operatorTransactionId
     */
    public void setOperatorTransactionId(java.lang.String operatorTransactionId) {
        this.operatorTransactionId = operatorTransactionId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopUp)) return false;
        TopUp other = (TopUp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.localCurrencyAmount==null && other.getLocalCurrencyAmount()==null) || 
             (this.localCurrencyAmount!=null &&
              this.localCurrencyAmount.equals(other.getLocalCurrencyAmount()))) &&
            ((this.salesTaxAmount==null && other.getSalesTaxAmount()==null) || 
             (this.salesTaxAmount!=null &&
              this.salesTaxAmount.equals(other.getSalesTaxAmount()))) &&
            ((this.localCurrencyAmountExcludingTax==null && other.getLocalCurrencyAmountExcludingTax()==null) || 
             (this.localCurrencyAmountExcludingTax!=null &&
              this.localCurrencyAmountExcludingTax.equals(other.getLocalCurrencyAmountExcludingTax()))) &&
            ((this.localCurrencyName==null && other.getLocalCurrencyName()==null) || 
             (this.localCurrencyName!=null &&
              this.localCurrencyName.equals(other.getLocalCurrencyName()))) &&
            ((this.newAccountBalance==null && other.getNewAccountBalance()==null) || 
             (this.newAccountBalance!=null &&
              this.newAccountBalance.equals(other.getNewAccountBalance()))) &&
            ((this.operatorTransactionId==null && other.getOperatorTransactionId()==null) || 
             (this.operatorTransactionId!=null &&
              this.operatorTransactionId.equals(other.getOperatorTransactionId())));
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
        if (getLocalCurrencyAmount() != null) {
            _hashCode += getLocalCurrencyAmount().hashCode();
        }
        if (getSalesTaxAmount() != null) {
            _hashCode += getSalesTaxAmount().hashCode();
        }
        if (getLocalCurrencyAmountExcludingTax() != null) {
            _hashCode += getLocalCurrencyAmountExcludingTax().hashCode();
        }
        if (getLocalCurrencyName() != null) {
            _hashCode += getLocalCurrencyName().hashCode();
        }
        if (getNewAccountBalance() != null) {
            _hashCode += getNewAccountBalance().hashCode();
        }
        if (getOperatorTransactionId() != null) {
            _hashCode += getOperatorTransactionId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopUp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "TopUp"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("localCurrencyAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "localCurrencyAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("salesTaxAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "salesTaxAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("localCurrencyAmountExcludingTax");
        attrField.setXmlName(new javax.xml.namespace.QName("", "localCurrencyAmountExcludingTax"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("localCurrencyName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "localCurrencyName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("newAccountBalance");
        attrField.setXmlName(new javax.xml.namespace.QName("", "newAccountBalance"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operatorTransactionId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "operatorTransactionId"));
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
