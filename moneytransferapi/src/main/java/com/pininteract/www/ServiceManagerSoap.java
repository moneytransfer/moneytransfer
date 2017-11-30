/**
 * ServiceManagerSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pininteract.www;

public interface ServiceManagerSoap extends java.rmi.Remote {
    public com.pininteract.OrderResponse rtrReturn(java.lang.String version, long transactionId, java.lang.String corelationId, java.lang.String storeId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse purchasePin(java.lang.String version, int skuId, int quantity, java.lang.String corelationId, java.lang.String storeId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse purchaseRtrByANI(java.lang.String version, java.lang.String mobile, java.math.BigDecimal amount, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse purchaseRtr(java.lang.String version, int skuId, int amount, java.lang.String mobile, java.lang.String corelationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse purchaseRtr2(java.lang.String version, int skuId, java.math.BigDecimal amount, java.lang.String mobile, java.lang.String corelationId, java.lang.String senderMobile, java.lang.String storeId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse billPay(java.lang.String version, int skuId, java.math.BigDecimal amount, java.lang.String accountNumber, java.lang.String checkDigits, java.lang.String correlationId, java.lang.String senderName, java.lang.String senderMobile, java.lang.String storeId, java.lang.String mobileNumber, java.lang.String accountType, java.lang.String accountStatus) throws java.rmi.RemoteException;
    public com.pininteract.CarrierListResponse getCarrierList(java.lang.String version) throws java.rmi.RemoteException;
    public com.pininteract.CarrierListResponse getCarrierList2(java.lang.String version, java.lang.String countryCode, java.lang.String currencyCode) throws java.rmi.RemoteException;
    public com.pininteract.www.SkuListResponse getSkuList(java.lang.String version) throws java.rmi.RemoteException;
    public com.pininteract.www.ExchangeRateInfo getExchangeRate(int skuId) throws java.rmi.RemoteException;
    public com.pininteract.www.SkuListResponse getSkuListByCarrier(java.lang.String version, int carrierId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse getInvoiceById(long salesInvoiceId) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse getInvoiceByCorrelationId(java.lang.String correlationId) throws java.rmi.RemoteException;
    public java.util.Calendar echo() throws java.rmi.RemoteException;
    public java.math.BigDecimal balanceInquiry() throws java.rmi.RemoteException;
    public com.pininteract.www.CarrierResponse getCarrierInfoByMobileNumber(java.lang.String version, java.lang.String mobile) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse activateSim(java.lang.String version, int skuId, java.lang.String simNumber, java.lang.String zipCode, java.lang.String language, java.lang.String email, java.lang.String mno, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId, int numberOfPlanMonths, java.lang.String areaCode) throws java.rmi.RemoteException;
    public com.pininteract.OrderResponse portInSim(java.lang.String version, int skuId, java.lang.String simNumber, java.lang.String zipCode, java.lang.String language, java.lang.String operatorCode, java.lang.String mobileNumber, java.lang.String accountNumber, java.lang.String passwordPin, java.lang.String email, java.lang.String mno, java.lang.String firstName, java.lang.String lastName, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String accountHolderZip, java.lang.String correlationId, java.lang.String senderMobile, java.lang.String storeId, int numberOfPlanMonths) throws java.rmi.RemoteException;
    public com.pininteract.www.SimPortInStatusResponse checkSimPortinStatus(java.lang.String version, long transactionId) throws java.rmi.RemoteException;
    public com.pininteract.PromotionsResponse getCurrentPromotions() throws java.rmi.RemoteException;
    public com.pininteract.PromotionsResponse getUpcomingPromotions() throws java.rmi.RemoteException;
    public com.pininteract.AccountLookupResponse accountLookup(java.lang.String version, int skuId, java.lang.String mobileNumber, java.lang.String accountStatus) throws java.rmi.RemoteException;
}
