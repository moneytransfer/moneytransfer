/**
 * Promotion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract;

public class Promotion  implements java.io.Serializable {
    private com.pininteract.PromotionsProduct product;

    private com.pininteract.PromotionMinMaxRange[] promotionMinMaxRanges;

    private java.lang.String promotionName;  // attribute

    private java.util.Calendar startDate;  // attribute

    private java.util.Calendar endDate;  // attribute

    private java.lang.String description;  // attribute

    private java.lang.String promotionalBalanceExpiration;  // attribute

    private java.lang.String restriction;  // attribute

    public Promotion() {
    }

    public Promotion(
           com.pininteract.PromotionsProduct product,
           com.pininteract.PromotionMinMaxRange[] promotionMinMaxRanges,
           java.lang.String promotionName,
           java.util.Calendar startDate,
           java.util.Calendar endDate,
           java.lang.String description,
           java.lang.String promotionalBalanceExpiration,
           java.lang.String restriction) {
           this.product = product;
           this.promotionMinMaxRanges = promotionMinMaxRanges;
           this.promotionName = promotionName;
           this.startDate = startDate;
           this.endDate = endDate;
           this.description = description;
           this.promotionalBalanceExpiration = promotionalBalanceExpiration;
           this.restriction = restriction;
    }


    /**
     * Gets the product value for this Promotion.
     * 
     * @return product
     */
    public com.pininteract.PromotionsProduct getProduct() {
        return product;
    }


    /**
     * Sets the product value for this Promotion.
     * 
     * @param product
     */
    public void setProduct(com.pininteract.PromotionsProduct product) {
        this.product = product;
    }


    /**
     * Gets the promotionMinMaxRanges value for this Promotion.
     * 
     * @return promotionMinMaxRanges
     */
    public com.pininteract.PromotionMinMaxRange[] getPromotionMinMaxRanges() {
        return promotionMinMaxRanges;
    }


    /**
     * Sets the promotionMinMaxRanges value for this Promotion.
     * 
     * @param promotionMinMaxRanges
     */
    public void setPromotionMinMaxRanges(com.pininteract.PromotionMinMaxRange[] promotionMinMaxRanges) {
        this.promotionMinMaxRanges = promotionMinMaxRanges;
    }


    /**
     * Gets the promotionName value for this Promotion.
     * 
     * @return promotionName
     */
    public java.lang.String getPromotionName() {
        return promotionName;
    }


    /**
     * Sets the promotionName value for this Promotion.
     * 
     * @param promotionName
     */
    public void setPromotionName(java.lang.String promotionName) {
        this.promotionName = promotionName;
    }


    /**
     * Gets the startDate value for this Promotion.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this Promotion.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this Promotion.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this Promotion.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the description value for this Promotion.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Promotion.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the promotionalBalanceExpiration value for this Promotion.
     * 
     * @return promotionalBalanceExpiration
     */
    public java.lang.String getPromotionalBalanceExpiration() {
        return promotionalBalanceExpiration;
    }


    /**
     * Sets the promotionalBalanceExpiration value for this Promotion.
     * 
     * @param promotionalBalanceExpiration
     */
    public void setPromotionalBalanceExpiration(java.lang.String promotionalBalanceExpiration) {
        this.promotionalBalanceExpiration = promotionalBalanceExpiration;
    }


    /**
     * Gets the restriction value for this Promotion.
     * 
     * @return restriction
     */
    public java.lang.String getRestriction() {
        return restriction;
    }


    /**
     * Sets the restriction value for this Promotion.
     * 
     * @param restriction
     */
    public void setRestriction(java.lang.String restriction) {
        this.restriction = restriction;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Promotion)) return false;
        Promotion other = (Promotion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.product==null && other.getProduct()==null) || 
             (this.product!=null &&
              this.product.equals(other.getProduct()))) &&
            ((this.promotionMinMaxRanges==null && other.getPromotionMinMaxRanges()==null) || 
             (this.promotionMinMaxRanges!=null &&
              java.util.Arrays.equals(this.promotionMinMaxRanges, other.getPromotionMinMaxRanges()))) &&
            ((this.promotionName==null && other.getPromotionName()==null) || 
             (this.promotionName!=null &&
              this.promotionName.equals(other.getPromotionName()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.promotionalBalanceExpiration==null && other.getPromotionalBalanceExpiration()==null) || 
             (this.promotionalBalanceExpiration!=null &&
              this.promotionalBalanceExpiration.equals(other.getPromotionalBalanceExpiration()))) &&
            ((this.restriction==null && other.getRestriction()==null) || 
             (this.restriction!=null &&
              this.restriction.equals(other.getRestriction())));
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
        if (getProduct() != null) {
            _hashCode += getProduct().hashCode();
        }
        if (getPromotionMinMaxRanges() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromotionMinMaxRanges());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromotionMinMaxRanges(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPromotionName() != null) {
            _hashCode += getPromotionName().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getPromotionalBalanceExpiration() != null) {
            _hashCode += getPromotionalBalanceExpiration().hashCode();
        }
        if (getRestriction() != null) {
            _hashCode += getRestriction().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Promotion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "Promotion"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotionName");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotionName"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("startDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("endDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotionalBalanceExpiration");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotionalBalanceExpiration"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("restriction");
        attrField.setXmlName(new javax.xml.namespace.QName("", "restriction"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "Product"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "PromotionsProduct"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotionMinMaxRanges");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:pininteract.com", "promotionMinMaxRanges"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:pininteract.com", "PromotionMinMaxRange"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:pininteract.com", "promotionMinMaxRange"));
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
