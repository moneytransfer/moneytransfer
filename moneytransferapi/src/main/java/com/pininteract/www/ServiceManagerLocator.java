/**
 * ServiceManagerLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract.www;

public class ServiceManagerLocator extends org.apache.axis.client.Service implements com.pininteract.www.ServiceManager {

    public ServiceManagerLocator() {
    }


    public ServiceManagerLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceManagerLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceManagerSoap
    private java.lang.String ServiceManagerSoap_address = "https://qa.valuetopup.com/posaservice/servicemanager.asmx";

    public java.lang.String getServiceManagerSoapAddress() {
        return ServiceManagerSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceManagerSoapWSDDServiceName = "ServiceManagerSoap";

    public java.lang.String getServiceManagerSoapWSDDServiceName() {
        return ServiceManagerSoapWSDDServiceName;
    }

    public void setServiceManagerSoapWSDDServiceName(java.lang.String name) {
        ServiceManagerSoapWSDDServiceName = name;
    }

    public com.pininteract.www.ServiceManagerSoap getServiceManagerSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceManagerSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceManagerSoap(endpoint);
    }

    public com.pininteract.www.ServiceManagerSoap getServiceManagerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.pininteract.www.ServiceManagerSoapStub _stub = new com.pininteract.www.ServiceManagerSoapStub(portAddress, this);
            _stub.setPortName(getServiceManagerSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceManagerSoapEndpointAddress(java.lang.String address) {
        ServiceManagerSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.pininteract.www.ServiceManagerSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.pininteract.www.ServiceManagerSoapStub _stub = new com.pininteract.www.ServiceManagerSoapStub(new java.net.URL(ServiceManagerSoap_address), this);
                _stub.setPortName(getServiceManagerSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiceManagerSoap".equals(inputPortName)) {
            return getServiceManagerSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.pininteract.com", "ServiceManager");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.pininteract.com", "ServiceManagerSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceManagerSoap".equals(portName)) {
            setServiceManagerSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
