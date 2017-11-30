/**
 * Sku.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class Sku  implements java.io.Serializable {
    private int skuId;  // attribute

    private java.lang.String productCode;  // attribute

    private java.lang.String productName;  // attribute

    private java.math.BigDecimal denomination;  // attribute

    private java.math.BigDecimal minAmount;  // attribute

    private java.math.BigDecimal maxAmount;  // attribute

    private java.math.BigDecimal discount;  // attribute

    private java.lang.String category;  // attribute

    private boolean isSalesTaxCharged;  // attribute

    private java.math.BigDecimal exchangeRate;  // attribute

    private java.math.BigDecimal bonusAmount;  // attribute

    private java.lang.String currencyCode;  // attribute

    private java.lang.String carrierName;  // attribute

    private java.lang.String countryCode;  // attribute

    private int localPhoneNumberLength;  // attribute

    private java.lang.String[] internationalCodes;  // attribute

    private boolean allowDecimal;  // attribute

    private java.math.BigDecimal fee;  // attribute

    private int carrierId;  // attribute

    private int operatorId;  // attribute

    private java.lang.String operatorName;  // attribute

    public Sku() {
    }

    public Sku(
           int skuId,
           java.lang.String productCode,
           java.lang.String productName,
           java.math.BigDecimal denomination,
           java.math.BigDecimal minAmount,
           java.math.BigDecimal maxAmount,
           java.math.BigDecimal discount,
           java.lang.String category,
           boolean isSalesTaxCharged,
           java.math.BigDecimal exchangeRate,
           java.math.BigDecimal bonusAmount,
           java.lang.String currencyCode,
           java.lang.String carrierName,
           java.lang.String countryCode,
           int localPhoneNumberLength,
           java.lang.String[] internationalCodes,
           boolean allowDecimal,
           java.math.BigDecimal fee,
           int carrierId,
           int operatorId,
           java.lang.String operatorName) {
           this.skuId = skuId;
           this.productCode = productCode;
           this.productName = productName;
           this.denomination = denomination;
           this.minAmount = minAmount;
           this.maxAmount = maxAmount;
           this.discount = discount;
           this.category = category;
           this.isSalesTaxCharged = isSalesTaxCharged;
           this.exchangeRate = exchangeRate;
           this.bonusAmount = bonusAmount;
           this.currencyCode = currencyCode;
           this.carrierName = carrierName;
           this.countryCode = countryCode;
           this.localPhoneNumberLength = localPhoneNumberLength;
           this.internationalCodes = internationalCodes;
           this.allowDecimal = allowDecimal;
           this.fee = fee;
           this.carrierId = carrierId;
           this.operatorId = operatorId;
           this.operatorName = operatorName;
    }


    /**
     * Gets the skuId value for this Sku.
     * 
     * @return skuId
     */
    public int getSkuId() {
        return skuId;
    }


    /**
     * Sets the skuId value for this Sku.
     * 
     * @param skuId
     */
    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }


    /**
     * Gets the productCode value for this Sku.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this Sku.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productName value for this Sku.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this Sku.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the denomination value for this Sku.
     * 
     * @return denomination
     */
    public java.math.BigDecimal getDenomination() {
        return denomination;
    }


    /**
     * Sets the denomination value for this Sku.
     * 
     * @param denomination
     */
    public void setDenomination(java.math.BigDecimal denomination) {
        this.denomination = denomination;
    }


    /**
     * Gets the minAmount value for this Sku.
     * 
     * @return minAmount
     */
    public java.math.BigDecimal getMinAmount() {
        return minAmount;
    }


    /**
     * Sets the minAmount value for this Sku.
     * 
     * @param minAmount
     */
    public void setMinAmount(java.math.BigDecimal minAmount) {
        this.minAmount = minAmount;
    }


    /**
     * Gets the maxAmount value for this Sku.
     * 
     * @return maxAmount
     */
    public java.math.BigDecimal getMaxAmount() {
        return maxAmount;
    }


    /**
     * Sets the maxAmount value for this Sku.
     * 
     * @param maxAmount
     */
    public void setMaxAmount(java.math.BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }


    /**
     * Gets the discount value for this Sku.
     * 
     * @return discount
     */
    public java.math.BigDecimal getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this Sku.
     * 
     * @param discount
     */
    public void setDiscount(java.math.BigDecimal discount) {
        this.discount = discount;
    }


    /**
     * Gets the category value for this Sku.
     * 
     * @return category
     */
    public java.lang.String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this Sku.
     * 
     * @param category
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
    }


    /**
     * Gets the isSalesTaxCharged value for this Sku.
     * 
     * @return isSalesTaxCharged
     */
    public boolean isIsSalesTaxCharged() {
        return isSalesTaxCharged;
    }


    /**
     * Sets the isSalesTaxCharged value for this Sku.
     * 
     * @param isSalesTaxCharged
     */
    public void setIsSalesTaxCharged(boolean isSalesTaxCharged) {
        this.isSalesTaxCharged = isSalesTaxCharged;
    }


    /**
     * Gets the exchangeRate value for this Sku.
     * 
     * @return exchangeRate
     */
    public java.math.BigDecimal getExchangeRate() {
        return exchangeRate;
    }


    /**
     * Sets the exchangeRate value for this Sku.
     * 
     * @param exchangeRate
     */
    public void setExchangeRate(java.math.BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }


    /**
     * Gets the bonusAmount value for this Sku.
     * 
     * @return bonusAmount
     */
    public java.math.BigDecimal getBonusAmount() {
        return bonusAmount;
    }


    /**
     * Sets the bonusAmount value for this Sku.
     * 
     * @param bonusAmount
     */
    public void setBonusAmount(java.math.BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }


    /**
     * Gets the currencyCode value for this Sku.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this Sku.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the carrierName value for this Sku.
     * 
     * @return carrierName
     */
    public java.lang.String getCarrierName() {
        return carrierName;
    }


    /**
     * Sets the carrierName value for this Sku.
     * 
     * @param carrierName
     */
    public void setCarrierName(java.lang.String carrierName) {
        this.carrierName = carrierName;
    }


    /**
     * Gets the countryCode value for this Sku.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this Sku.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the localPhoneNumberLength value for this Sku.
     * 
     * @return localPhoneNumberLength
     */
    public int getLocalPhoneNumberLength() {
        return localPhoneNumberLength;
    }


    /**
     * Sets the localPhoneNumberLength value for this Sku.
     * 
     * @param localPhoneNumberLength
     */
    public void setLocalPhoneNumberLength(int localPhoneNumberLength) {
        this.localPhoneNumberLength = localPhoneNumberLength;
    }


    /**
     * Gets the internationalCodes value for this Sku.
     * 
     * @return internationalCodes
     */
    public java.lang.String[] getInternationalCodes() {
        return internationalCodes;
    }


    /**
     * Sets the internationalCodes value for this Sku.
     * 
     * @param internationalCodes
     */
    public void setInternationalCodes(java.lang.String[] internationalCodes) {
        this.internationalCodes = internationalCodes;
    }


    /**
     * Gets the allowDecimal value for this Sku.
     * 
     * @return allowDecimal
     */
    public boolean isAllowDecimal() {
        return allowDecimal;
    }


    /**
     * Sets the allowDecimal value for this Sku.
     * 
     * @param allowDecimal
     */
    public void setAllowDecimal(boolean allowDecimal) {
        this.allowDecimal = allowDecimal;
    }


    /**
     * Gets the fee value for this Sku.
     * 
     * @return fee
     */
    public java.math.BigDecimal getFee() {
        return fee;
    }


    /**
     * Sets the fee value for this Sku.
     * 
     * @param fee
     */
    public void setFee(java.math.BigDecimal fee) {
        this.fee = fee;
    }


    /**
     * Gets the carrierId value for this Sku.
     * 
     * @return carrierId
     */
    public int getCarrierId() {
        return carrierId;
    }


    /**
     * Sets the carrierId value for this Sku.
     * 
     * @param carrierId
     */
    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }


    /**
     * Gets the operatorId value for this Sku.
     * 
     * @return operatorId
     */
    public int getOperatorId() {
        return operatorId;
    }


    /**
     * Sets the operatorId value for this Sku.
     * 
     * @param operatorId
     */
    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }


    /**
     * Gets the operatorName value for this Sku.
     * 
     * @return operatorName
     */
    public java.lang.String getOperatorName() {
        return operatorName;
    }


    /**
     * Sets the operatorName value for this Sku.
     * 
     * @param operatorName
     */
    public void setOperatorName(java.lang.String operatorName) {
        this.operatorName = operatorName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sku)) return false;
        Sku other = (Sku) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.skuId == other.getSkuId() &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.denomination==null && other.getDenomination()==null) || 
             (this.denomination!=null &&
              this.denomination.equals(other.getDenomination()))) &&
            ((this.minAmount==null && other.getMinAmount()==null) || 
             (this.minAmount!=null &&
              this.minAmount.equals(other.getMinAmount()))) &&
            ((this.maxAmount==null && other.getMaxAmount()==null) || 
             (this.maxAmount!=null &&
              this.maxAmount.equals(other.getMaxAmount()))) &&
            ((this.discount==null && other.getDiscount()==null) || 
             (this.discount!=null &&
              this.discount.equals(other.getDiscount()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            this.isSalesTaxCharged == other.isIsSalesTaxCharged() &&
            ((this.exchangeRate==null && other.getExchangeRate()==null) || 
             (this.exchangeRate!=null &&
              this.exchangeRate.equals(other.getExchangeRate()))) &&
            ((this.bonusAmount==null && other.getBonusAmount()==null) || 
             (this.bonusAmount!=null &&
              this.bonusAmount.equals(other.getBonusAmount()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.carrierName==null && other.getCarrierName()==null) || 
             (this.carrierName!=null &&
              this.carrierName.equals(other.getCarrierName()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            this.localPhoneNumberLength == other.getLocalPhoneNumberLength() &&
            ((this.internationalCodes==null && other.getInternationalCodes()==null) || 
             (this.internationalCodes!=null &&
              java.util.Arrays.equals(this.internationalCodes, other.getInternationalCodes()))) &&
            this.allowDecimal == other.isAllowDecimal() &&
            ((this.fee==null && other.getFee()==null) || 
             (this.fee!=null &&
              this.fee.equals(other.getFee()))) &&
            this.carrierId == other.getCarrierId() &&
            this.operatorId == other.getOperatorId() &&
            ((this.operatorName==null && other.getOperatorName()==null) || 
             (this.operatorName!=null &&
              this.operatorName.equals(other.getOperatorName())));
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
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getDenomination() != null) {
            _hashCode += getDenomination().hashCode();
        }
        if (getMinAmount() != null) {
            _hashCode += getMinAmount().hashCode();
        }
        if (getMaxAmount() != null) {
            _hashCode += getMaxAmount().hashCode();
        }
        if (getDiscount() != null) {
            _hashCode += getDiscount().hashCode();
        }
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        _hashCode += (isIsSalesTaxCharged() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getExchangeRate() != null) {
            _hashCode += getExchangeRate().hashCode();
        }
        if (getBonusAmount() != null) {
            _hashCode += getBonusAmount().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getCarrierName() != null) {
            _hashCode += getCarrierName().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        _hashCode += getLocalPhoneNumberLength();
        if (getInternationalCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInternationalCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInternationalCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isAllowDecimal() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFee() != null) {
            _hashCode += getFee().hashCode();
        }
        _hashCode += getCarrierId();
        _hashCode += getOperatorId();
        if (getOperatorName() != null) {
            _hashCode += getOperatorName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sku.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Sku"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("skuId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "skuId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("productCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "productCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("productName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("denomination");
        attrField.setXmlName(new javax.xml.namespace.QName("", "denomination"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("minAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "minAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("maxAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "maxAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("isSalesTaxCharged");
        attrField.setXmlName(new javax.xml.namespace.QName("", "isSalesTaxCharged"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("exchangeRate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "exchangeRate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bonusAmount");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bonusAmount"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currencyCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currencyCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("carrierName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "carrierName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("countryCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "countryCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("localPhoneNumberLength");
        attrField.setXmlName(new javax.xml.namespace.QName("", "localPhoneNumberLength"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("internationalCodes");
        attrField.setXmlName(new javax.xml.namespace.QName("", "internationalCodes"));
        attrField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", ">Sku>internationalCodes"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("allowDecimal");
        attrField.setXmlName(new javax.xml.namespace.QName("", "allowDecimal"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fee");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fee"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("carrierId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "carrierId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operatorId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "operatorId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operatorName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "operatorName"));
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
