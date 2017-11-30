/**
 * Carrier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract.www;

public class Carrier  implements java.io.Serializable {
    private com.pininteract.www.Sku[] skus;

    private int carrierId;  // attribute

    private java.lang.String carrierName;  // attribute

    private java.lang.String category;  // attribute

    private java.lang.String countryCode;  // attribute

    private java.lang.String currencyCode;  // attribute

    private int productId;  // attribute

    private java.lang.String operator;  // attribute

    private java.lang.String mccCode;  // attribute

    private java.lang.String mncCode;  // attribute

    private java.lang.String denominationType;  // attribute

    public Carrier() {
    }

    public Carrier(
           com.pininteract.www.Sku[] skus,
           int carrierId,
           java.lang.String carrierName,
           java.lang.String category,
           java.lang.String countryCode,
           java.lang.String currencyCode,
           int productId,
           java.lang.String operator,
           java.lang.String mccCode,
           java.lang.String mncCode,
           java.lang.String denominationType) {
           this.skus = skus;
           this.carrierId = carrierId;
           this.carrierName = carrierName;
           this.category = category;
           this.countryCode = countryCode;
           this.currencyCode = currencyCode;
           this.productId = productId;
           this.operator = operator;
           this.mccCode = mccCode;
           this.mncCode = mncCode;
           this.denominationType = denominationType;
    }


    /**
     * Gets the skus value for this Carrier.
     * 
     * @return skus
     */
    public com.pininteract.www.Sku[] getSkus() {
        return skus;
    }


    /**
     * Sets the skus value for this Carrier.
     * 
     * @param skus
     */
    public void setSkus(com.pininteract.www.Sku[] skus) {
        this.skus = skus;
    }


    /**
     * Gets the carrierId value for this Carrier.
     * 
     * @return carrierId
     */
    public int getCarrierId() {
        return carrierId;
    }


    /**
     * Sets the carrierId value for this Carrier.
     * 
     * @param carrierId
     */
    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }


    /**
     * Gets the carrierName value for this Carrier.
     * 
     * @return carrierName
     */
    public java.lang.String getCarrierName() {
        return carrierName;
    }


    /**
     * Sets the carrierName value for this Carrier.
     * 
     * @param carrierName
     */
    public void setCarrierName(java.lang.String carrierName) {
        this.carrierName = carrierName;
    }


    /**
     * Gets the category value for this Carrier.
     * 
     * @return category
     */
    public java.lang.String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this Carrier.
     * 
     * @param category
     */
    public void setCategory(java.lang.String category) {
        this.category = category;
    }


    /**
     * Gets the countryCode value for this Carrier.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this Carrier.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the currencyCode value for this Carrier.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this Carrier.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the productId value for this Carrier.
     * 
     * @return productId
     */
    public int getProductId() {
        return productId;
    }


    /**
     * Sets the productId value for this Carrier.
     * 
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }


    /**
     * Gets the operator value for this Carrier.
     * 
     * @return operator
     */
    public java.lang.String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this Carrier.
     * 
     * @param operator
     */
    public void setOperator(java.lang.String operator) {
        this.operator = operator;
    }


    /**
     * Gets the mccCode value for this Carrier.
     * 
     * @return mccCode
     */
    public java.lang.String getMccCode() {
        return mccCode;
    }


    /**
     * Sets the mccCode value for this Carrier.
     * 
     * @param mccCode
     */
    public void setMccCode(java.lang.String mccCode) {
        this.mccCode = mccCode;
    }


    /**
     * Gets the mncCode value for this Carrier.
     * 
     * @return mncCode
     */
    public java.lang.String getMncCode() {
        return mncCode;
    }


    /**
     * Sets the mncCode value for this Carrier.
     * 
     * @param mncCode
     */
    public void setMncCode(java.lang.String mncCode) {
        this.mncCode = mncCode;
    }


    /**
     * Gets the denominationType value for this Carrier.
     * 
     * @return denominationType
     */
    public java.lang.String getDenominationType() {
        return denominationType;
    }


    /**
     * Sets the denominationType value for this Carrier.
     * 
     * @param denominationType
     */
    public void setDenominationType(java.lang.String denominationType) {
        this.denominationType = denominationType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Carrier)) return false;
        Carrier other = (Carrier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.skus==null && other.getSkus()==null) || 
             (this.skus!=null &&
              java.util.Arrays.equals(this.skus, other.getSkus()))) &&
            this.carrierId == other.getCarrierId() &&
            ((this.carrierName==null && other.getCarrierName()==null) || 
             (this.carrierName!=null &&
              this.carrierName.equals(other.getCarrierName()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            this.productId == other.getProductId() &&
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.mccCode==null && other.getMccCode()==null) || 
             (this.mccCode!=null &&
              this.mccCode.equals(other.getMccCode()))) &&
            ((this.mncCode==null && other.getMncCode()==null) || 
             (this.mncCode!=null &&
              this.mncCode.equals(other.getMncCode()))) &&
            ((this.denominationType==null && other.getDenominationType()==null) || 
             (this.denominationType!=null &&
              this.denominationType.equals(other.getDenominationType())));
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
        if (getSkus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSkus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSkus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCarrierId();
        if (getCarrierName() != null) {
            _hashCode += getCarrierName().hashCode();
        }
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        _hashCode += getProductId();
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getMccCode() != null) {
            _hashCode += getMccCode().hashCode();
        }
        if (getMncCode() != null) {
            _hashCode += getMncCode().hashCode();
        }
        if (getDenominationType() != null) {
            _hashCode += getDenominationType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Carrier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.pininteract.com", "Carrier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("carrierId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "carrierId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("carrierName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "carrierName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("category");
        attrField.setXmlName(new javax.xml.namespace.QName("", "category"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("countryCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "countryCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currencyCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currencyCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("productId");
        attrField.setXmlName(new javax.xml.namespace.QName("", "productId"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("operator");
        attrField.setXmlName(new javax.xml.namespace.QName("", "operator"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mccCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mccCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mncCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "mncCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("denominationType");
        attrField.setXmlName(new javax.xml.namespace.QName("", "denominationType"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.pininteract.com", "skus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.pininteract.com", "Sku"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.pininteract.com", "sku"));
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
