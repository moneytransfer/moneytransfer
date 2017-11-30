package com.pininteract.www;

public class ServiceManagerSoapProxy implements com.pininteract.www.ServiceManagerSoap {
  private String _endpoint = null;
  private com.pininteract.www.ServiceManagerSoap serviceManagerSoap = null;
  
  public ServiceManagerSoapProxy() {
    _initServiceManagerSoapProxy();
  }
  
  public ServiceManagerSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceManagerSoapProxy();
  }
  
  private void _initServiceManagerSoapProxy() {
    try {
      serviceManagerSoap = (new com.pininteract.www.ServiceManagerLocator()).getServiceManagerSoap();
      if (serviceManagerSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceManagerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceManagerSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceManagerSoap != null)
      ((javax.xml.rpc.Stub)serviceManagerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.pininteract.www.ServiceManagerSoap getServiceManagerSoap() {
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap;
  }
  
  public com.pininteract.OrderResponse rtrReturn(java.lang.String version, long transactionId, java.lang.String corelationId, java.lang.String storeId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.rtrReturn(version, transactionId, corelationId, storeId);
  }
  
  public com.pininteract.OrderResponse purchasePin(java.lang.String version, int skuId, int quantity, java.lang.String corelationId, java.lang.String storeId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.purchasePin(version, skuId, quantity, corelationId, storeId);
  }
  
  public com.pininteract.OrderResponse purchaseRtrByANI(java.lang.String version, java.lang.String mobile, java.math.BigDecimal amount, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.purchaseRtrByANI(version, mobile, amount, correlationId, senderMobile, storeId);
  }
  
  public com.pininteract.OrderResponse purchaseRtr(java.lang.String version, int skuId, int amount, java.lang.String mobile, java.lang.String corelationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.purchaseRtr(version, skuId, amount, mobile, corelationId, senderMobile, storeId);
  }
  
  public com.pininteract.OrderResponse purchaseRtr2(java.lang.String version, int skuId, java.math.BigDecimal amount, java.lang.String mobile, java.lang.String corelationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.purchaseRtr2(version, skuId, amount, mobile, corelationId, senderMobile, storeId);
  }
  
  public com.pininteract.OrderResponse billPay(java.lang.String version, int skuId, java.math.BigDecimal amount, java.lang.String accountNumber, java.lang.String checkDigits, java.lang.String correlationId, java.lang.String senderName, java.lang.String senderMobile, java.lang.String storeId, java.lang.String mobileNumber, java.lang.String accountType, java.lang.String accountStatus) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.billPay(version, skuId, amount, accountNumber, checkDigits, correlationId, senderName, senderMobile, storeId, mobileNumber, accountType, accountStatus);
  }
  
  public com.pininteract.CarrierListResponse getCarrierList(java.lang.String version) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getCarrierList(version);
  }
  
  public com.pininteract.CarrierListResponse getCarrierList2(java.lang.String version, java.lang.String countryCode, java.lang.String currencyCode) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getCarrierList2(version, countryCode, currencyCode);
  }
  
  public com.pininteract.www.SkuListResponse getSkuList(java.lang.String version) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getSkuList(version);
  }
  
  public com.pininteract.www.ExchangeRateInfo getExchangeRate(int skuId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getExchangeRate(skuId);
  }
  
  public com.pininteract.www.SkuListResponse getSkuListByCarrier(java.lang.String version, int carrierId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getSkuListByCarrier(version, carrierId);
  }
  
  public com.pininteract.OrderResponse getInvoiceById(long salesInvoiceId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getInvoiceById(salesInvoiceId);
  }
  
  public com.pininteract.OrderResponse getInvoiceByCorrelationId(java.lang.String correlationId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getInvoiceByCorrelationId(correlationId);
  }
  
  public java.util.Calendar echo() throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.echo();
  }
  
  public java.math.BigDecimal balanceInquiry() throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.balanceInquiry();
  }
  
  public com.pininteract.www.CarrierResponse getCarrierInfoByMobileNumber(java.lang.String version, java.lang.String mobile) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getCarrierInfoByMobileNumber(version, mobile);
  }
  
  public com.pininteract.OrderResponse activateSim(java.lang.String version, int skuId, java.lang.String simNumber, java.lang.String zipCode, java.lang.String language, java.lang.String email, java.lang.String mno, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId, int numberOfPlanMonths, java.lang.String areaCode) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.activateSim(version, skuId, simNumber, zipCode, language, email, mno, correlationId, senderMobile, storeId, numberOfPlanMonths, areaCode);
  }
  
  public com.pininteract.OrderResponse portInSim(java.lang.String version, int skuId, java.lang.String simNumber, java.lang.String zipCode, java.lang.String language, java.lang.String operatorCode, java.lang.String mobileNumber, java.lang.String accountNumber, java.lang.String passwordPin, java.lang.String email, java.lang.String mno, java.lang.String firstName, java.lang.String lastName, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String accountHolderZip, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId, int numberOfPlanMonths) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.portInSim(version, skuId, simNumber, zipCode, language, operatorCode, mobileNumber, accountNumber, passwordPin, email, mno, firstName, lastName, address, city, state, accountHolderZip, correlationId, senderMobile, storeId, numberOfPlanMonths);
  }
  
  public com.pininteract.www.SimPortInStatusResponse checkSimPortinStatus(java.lang.String version, long transactionId) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.checkSimPortinStatus(version, transactionId);
  }
  
  public com.pininteract.PromotionsResponse getCurrentPromotions() throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getCurrentPromotions();
  }
  
  public com.pininteract.PromotionsResponse getUpcomingPromotions() throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.getUpcomingPromotions();
  }
  
  public com.pininteract.AccountLookupResponse accountLookup(java.lang.String version, int skuId, java.lang.String mobileNumber, java.lang.String accountStatus) throws java.rmi.RemoteException{
    if (serviceManagerSoap == null)
      _initServiceManagerSoapProxy();
    return serviceManagerSoap.accountLookup(version, skuId, mobileNumber, accountStatus);
  }
  
  
}