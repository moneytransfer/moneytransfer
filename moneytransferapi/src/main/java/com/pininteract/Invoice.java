/**
 * Invoice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class Invoice  implements java.io.Serializable {
    private com.pininteract.Card[] cards;

    private long invoiceNumber;  // attribute

    private java.util.Calendar transactionDateTime;  // attribute

    private java.math.BigDecimal invoiceAmount;  // attribute

    private java.math.BigDecimal faceValueAmount;  // attribute

    private java.math.BigDecimal discount;  // attribute

    private java.math.BigDecimal fee;  // attribute

    public Invoice() {
    }

    public Invoice(
           com.pininteract.Card[] cards,
           long invoiceNumber,
           java.util.Calendar transactionDateTime,
           java.math.BigDecimal invoiceAmount,
           java.math.BigDecimal faceValueAmount,
           java.math.BigDecimal discount,
           java.math.BigDecimal fee) {
           this.cards = cards;
           this.invoiceNumber = invoiceNumber;
           this.transactionDateTime = transactionDateTime;
           this.invoiceAmount = invoiceAmount;
           this.faceValueAmount = faceValueAmount;
           this.discount = discount;
           this.fee = fee;
    }


    /**
     * Gets the cards value for this Invoice.
     * 
     * @return cards
     */
    public com.pininteract.Card[] getCards() {
        return cards;
    }


    /**
     * Sets the cards value for this Invoice.
     * 
     * @param cards
     */
    public void setCards(com.pininteract.Card[] cards) {
        this.cards = cards;
    }


    /**
     * Gets the invoiceNumber value for this Invoice.
     * 
     * @return invoiceNumber
     */
    public long getInvoiceNumber() {
        return invoiceNumber;
    }


    /**
     * Sets the invoiceNumber value for this Invoice.
     * 
     * @param invoiceNumber
     */
    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }


    /**
     * Gets the transactionDateTime value for this Invoice.
     * 
     * @return transactionDateTime
     */
    public java.util.Calendar getTransactionDateTime() {
        return transactionDateTime;
    }


    /**
     * Sets the transactionDateTime value for this Invoice.
     * 
     * @param transactionDateTime
     */
    public void setTransactionDateTime(java.util.Calendar transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }


    /**
     * Gets the invoiceAmount value for this Invoice.
     * 
     * @return invoiceAmount
     */
    public java.math.BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }


    /**
     * Sets the invoiceAmount value for this Invoice.
     * 
     * @param invoiceAmount
     */
    public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }


    /**
     * Gets the faceValueAmount value for this Invoice.
     * 
     * @return faceValueAmount
     */
    public java.math.BigDecimal getFaceValueAmount() {
        return faceValueAmount;
    }


    /**
     * Sets the faceValueAmount value for this Invoice.
     * 
     * @param faceValueAmount
     */
    public void setFaceValueAmount(java.math.BigDecimal faceValueAmount) {
        this.faceValueAmount = faceValueAmount;
    }


    /**
     * Gets the discount value for this Invoice.
     * 
     * @return discount
     */
    public java.math.BigDecimal getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this Invoice.
     * 
     * @param discount
     */
    public void setDiscount(java.math.BigDecimal discount) {
        this.discount = discount;
    }


    /**
     * Gets the fee value for this Invoice.
     * 
     * @return fee
     */
    public java.math.BigDecimal getFee() {
        return fee;
    }


    /**
     * Sets the fee value for this Invoice.
     * 
     * @param fee
     */
    public void setFee(java.math.BigDecimal fee) {
        this.fee = fee;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Invoice)) return false;
        Invoice other = (Invoice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cards==null && other.getCards()==null) || 
             (this.cards!=null &&
              java.util.Arrays.equals(this.cards, other.getCards()))) &&
            this.invoiceNumber == other.getInvoiceNumber() &&
            ((this.transactionDateTime==null && other.getTransactionDateTime()==null) || 
             (this.transactionDateTime!=null &&
              this.transactionDateTime.equals(other.getTransactionDateTime()))) &&
            ((this.invoiceAmount==null && other.getInvoiceAmount()==null) || 
             (this.invoiceAmount!=null &&
              this.invoiceAmount.equals(other.getInvoiceAmount()))) &&
            ((this.faceValueAmount==null && other.getFaceValueAmount()==null) || 
             (this.faceValueAmount!=null &&
              this.faceValueAmount.equals(other.getFaceValueAmount()))) &&
            ((this.discount==null && other.getDiscount()==null) || 
             (this.discount!=null &&
              this.discount.equals(other.getDiscount()))) &&
            ((this.fee==null && other.getFee()==null) || 
             (this.fee!=null &&
              this.fee.equals(other.getFee())));
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
        if (getCards() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCards());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCards(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getInvoiceNumber()).hashCode();
        if (getTransactionDateTime() != null) {
            _hashCode += getTransactionDateTime().hashCode();
        }
        if (getInvoiceAmount() != null) {
            _hashCode += getInvoiceAmount().hashCode();
        }
        if (getFaceValueAmount() != null) {
            _hashCode += getFaceValueAmount().hashCode();
        }
        if (getDiscount() != null) {
            _hashCode += getDiscount().hashCode();
        }
        if (getFee() != null) {
            _hashCode += getFee().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Invoice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Invoice"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoiceNumber");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoiceNumber"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transactionDateTime");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transactionDateTime"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("invoiceAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "invoiceAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("faceValueAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "faceValueAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fee");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fee"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cards");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "cards"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Card"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:pininteract.com", "card"));
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
