/**
 * SimPortInStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract.www;

public class SimPortInStatusResponse  implements java.io.Serializable {
    private java.lang.String version;  // attribute

    private java.lang.String responseCode;  // attribute

    private java.lang.String responseMessage;  // attribute

    private java.lang.String donorOperator;  // attribute

    private java.lang.String portInDate;  // attribute

    private java.lang.String portInMSISDN;  // attribute

    private java.lang.String rejectCode;  // attribute

    private java.lang.String rejectReason;  // attribute

    private java.util.Calendar requestRaisedDate;  // attribute

    private java.lang.String portInStatus;  // attribute

    public SimPortInStatusResponse() {
    }

    public SimPortInStatusResponse(
           java.lang.String version,
           java.lang.String responseCode,
           java.lang.String responseMessage,
           java.lang.String donorOperator,
           java.lang.String portInDate,
           java.lang.String portInMSISDN,
           java.lang.String rejectCode,
           java.lang.String rejectReason,
           java.util.Calendar requestRaisedDate,
           java.lang.String portInStatus) {
           this.version = version;
           this.responseCode = responseCode;
           this.responseMessage = responseMessage;
           this.donorOperator = donorOperator;
           this.portInDate = portInDate;
           this.portInMSISDN = portInMSISDN;
           this.rejectCode = rejectCode;
           this.rejectReason = rejectReason;
           this.requestRaisedDate = requestRaisedDate;
           this.portInStatus = portInStatus;
    }


    /**
     * Gets the version value for this SimPortInStatusResponse.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this SimPortInStatusResponse.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the responseCode value for this SimPortInStatusResponse.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this SimPortInStatusResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the responseMessage value for this SimPortInStatusResponse.
     * 
     * @return responseMessage
     */
    public java.lang.String getResponseMessage() {
        return responseMessage;
    }


    /**
     * Sets the responseMessage value for this SimPortInStatusResponse.
     * 
     * @param responseMessage
     */
    public void setResponseMessage(java.lang.String responseMessage) {
        this.responseMessage = responseMessage;
    }


    /**
     * Gets the donorOperator value for this SimPortInStatusResponse.
     * 
     * @return donorOperator
     */
    public java.lang.String getDonorOperator() {
        return donorOperator;
    }


    /**
     * Sets the donorOperator value for this SimPortInStatusResponse.
     * 
     * @param donorOperator
     */
    public void setDonorOperator(java.lang.String donorOperator) {
        this.donorOperator = donorOperator;
    }


    /**
     * Gets the portInDate value for this SimPortInStatusResponse.
     * 
     * @return portInDate
     */
    public java.lang.String getPortInDate() {
        return portInDate;
    }


    /**
     * Sets the portInDate value for this SimPortInStatusResponse.
     * 
     * @param portInDate
     */
    public void setPortInDate(java.lang.String portInDate) {
        this.portInDate = portInDate;
    }


    /**
     * Gets the portInMSISDN value for this SimPortInStatusResponse.
     * 
     * @return portInMSISDN
     */
    public java.lang.String getPortInMSISDN() {
        return portInMSISDN;
    }


    /**
     * Sets the portInMSISDN value for this SimPortInStatusResponse.
     * 
     * @param portInMSISDN
     */
    public void setPortInMSISDN(java.lang.String portInMSISDN) {
        this.portInMSISDN = portInMSISDN;
    }


    /**
     * Gets the rejectCode value for this SimPortInStatusResponse.
     * 
     * @return rejectCode
     */
    public java.lang.String getRejectCode() {
        return rejectCode;
    }


    /**
     * Sets the rejectCode value for this SimPortInStatusResponse.
     * 
     * @param rejectCode
     */
    public void setRejectCode(java.lang.String rejectCode) {
        this.rejectCode = rejectCode;
    }


    /**
     * Gets the rejectReason value for this SimPortInStatusResponse.
     * 
     * @return rejectReason
     */
    public java.lang.String getRejectReason() {
        return rejectReason;
    }


    /**
     * Sets the rejectReason value for this SimPortInStatusResponse.
     * 
     * @param rejectReason
     */
    public void setRejectReason(java.lang.String rejectReason) {
        this.rejectReason = rejectReason;
    }


    /**
     * Gets the requestRaisedDate value for this SimPortInStatusResponse.
     * 
     * @return requestRaisedDate
     */
    public java.util.Calendar getRequestRaisedDate() {
        return requestRaisedDate;
    }


    /**
     * Sets the requestRaisedDate value for this SimPortInStatusResponse.
     * 
     * @param requestRaisedDate
     */
    public void setRequestRaisedDate(java.util.Calendar requestRaisedDate) {
        this.requestRaisedDate = requestRaisedDate;
    }


    /**
     * Gets the portInStatus value for this SimPortInStatusResponse.
     * 
     * @return portInStatus
     */
    public java.lang.String getPortInStatus() {
        return portInStatus;
    }


    /**
     * Sets the portInStatus value for this SimPortInStatusResponse.
     * 
     * @param portInStatus
     */
    public void setPortInStatus(java.lang.String portInStatus) {
        this.portInStatus = portInStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimPortInStatusResponse)) return false;
        SimPortInStatusResponse other = (SimPortInStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.responseMessage==null && other.getResponseMessage()==null) || 
             (this.responseMessage!=null &&
              this.responseMessage.equals(other.getResponseMessage()))) &&
            ((this.donorOperator==null && other.getDonorOperator()==null) || 
             (this.donorOperator!=null &&
              this.donorOperator.equals(other.getDonorOperator()))) &&
            ((this.portInDate==null && other.getPortInDate()==null) || 
             (this.portInDate!=null &&
              this.portInDate.equals(other.getPortInDate()))) &&
            ((this.portInMSISDN==null && other.getPortInMSISDN()==null) || 
             (this.portInMSISDN!=null &&
              this.portInMSISDN.equals(other.getPortInMSISDN()))) &&
            ((this.rejectCode==null && other.getRejectCode()==null) || 
             (this.rejectCode!=null &&
              this.rejectCode.equals(other.getRejectCode()))) &&
            ((this.rejectReason==null && other.getRejectReason()==null) || 
             (this.rejectReason!=null &&
              this.rejectReason.equals(other.getRejectReason()))) &&
            ((this.requestRaisedDate==null && other.getRequestRaisedDate()==null) || 
             (this.requestRaisedDate!=null &&
              this.requestRaisedDate.equals(other.getRequestRaisedDate()))) &&
            ((this.portInStatus==null && other.getPortInStatus()==null) || 
             (this.portInStatus!=null &&
              this.portInStatus.equals(other.getPortInStatus())));
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
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getResponseMessage() != null) {
            _hashCode += getResponseMessage().hashCode();
        }
        if (getDonorOperator() != null) {
            _hashCode += getDonorOperator().hashCode();
        }
        if (getPortInDate() != null) {
            _hashCode += getPortInDate().hashCode();
        }
        if (getPortInMSISDN() != null) {
            _hashCode += getPortInMSISDN().hashCode();
        }
        if (getRejectCode() != null) {
            _hashCode += getRejectCode().hashCode();
        }
        if (getRejectReason() != null) {
            _hashCode += getRejectReason().hashCode();
        }
        if (getRequestRaisedDate() != null) {
            _hashCode += getRequestRaisedDate().hashCode();
        }
        if (getPortInStatus() != null) {
            _hashCode += getPortInStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimPortInStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.pininteract.com", "SimPortInStatusResponse"));
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
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("donorOperator");
        attrField.setXmlName(new javax.xml.namespace.QName("", "donorOperator"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("portInDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "portInDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("portInMSISDN");
        attrField.setXmlName(new javax.xml.namespace.QName("", "portInMSISDN"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rejectCode");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rejectCode"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rejectReason");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rejectReason"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("requestRaisedDate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "requestRaisedDate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("portInStatus");
        attrField.setXmlName(new javax.xml.namespace.QName("", "portInStatus"));
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
