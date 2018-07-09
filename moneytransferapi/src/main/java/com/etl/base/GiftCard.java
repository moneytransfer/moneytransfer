package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class GiftCard {

	public int TransactionId;
	public int GiftCardid;
	public String GiftCardName;
	public double GiftCardInitialsPrice;
	public double GiftCardPrice;
	public String GiftCardCreatedDate;
	public int CompanyId;
	public int CustomerId;
	public String TransactionDetail;
	public double SendingAmount;
	public double Charges;
	public double Fees;
	public double Tax;
	public double ReceivingAmount;
	public int PaymentMethodId;
	public int BeneficiaryId;
	public String TransferPurpose;
	public String DeliveryType;
	public String Result;
	public String Error;
	public String CardNumber;
	public String setExpirationDate;
	public String cvv;
	public int SendingCurrencyId;	
	public int ReceivingCurrencytId;
	public double ExchangeRate;
	public String PaymentGatewayTransactionId;
	public String SenderName;
	
	
	
	
	private void setTransactionId(int TransactionId) {
		this.TransactionId = TransactionId;
	}

	private int getTransactionId() {
		return TransactionId;
	}
	
	private void setSenderName(String SenderName) {
		this.SenderName = SenderName;
	}

	private String getSenderName() {
		return SenderName;
	}
	
	
	private void setPaymentGatewayTransactionId(String PaymentGatewayTransactionId) {
		this.PaymentGatewayTransactionId = PaymentGatewayTransactionId;
	}

	private String getPaymentGatewayTransactionId() {
		return PaymentGatewayTransactionId;
	}
	private void setcvv(String cvv) {
		this.cvv = cvv;
	}

	private String getcvv() {
		return cvv;
	}

	private void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}

	private String getCardNumber() {
		return CardNumber;
	}

	private void setExpirationDate(String setExpirationDate) {
		this.setExpirationDate = setExpirationDate;
	}

	private String getExpirationDate() {
		return setExpirationDate;
	}
	
	private void setExchangeRate(double ExchangeRate) {
		this.ExchangeRate = ExchangeRate;
	}

	private double getExchangeRate() {
		return ExchangeRate;
	}
	private void setSendingCurrencyId(int SendingCurrencyId) {
		this.SendingCurrencyId = SendingCurrencyId;
	}

	private int getSendingCurrencyId() {
		return SendingCurrencyId;
	}

	private void setReceivingCurrencytId(int ReceivingCurrencytId) {
		this.ReceivingCurrencytId = ReceivingCurrencytId;
	}

	private int getReceivingCurrencytId() {
		return ReceivingCurrencytId;
	}
	
	
	private void setGiftCardid(int GiftCardid) {
		this.GiftCardid = GiftCardid;
	}

	private int getGiftCardid() {
		return GiftCardid;
	}

	private void setCustomerId(int CustomerId) {
		this.CustomerId = CustomerId;
	}

	private int getCustomerId() {
		return CustomerId;
	}

	private void setGiftCardName(String GiftCardName) {
		this.GiftCardName = GiftCardName;
	}

	private String getGiftCardName() {
		return GiftCardName;
	}

	private void setGiftCardPrice(Double GiftCardPrice) {
		this.GiftCardPrice = GiftCardPrice;
	}

	private Double getGiftCardPrice() {
		return GiftCardPrice;
	}

	private void setGiftCardCreatedDate(String GiftCardCreatedDate) {
		this.GiftCardCreatedDate = GiftCardCreatedDate;
	}

	private String getGiftCardCreatedDate() {
		return GiftCardCreatedDate;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setTransactionDetail(String TransactionDetail) {
		this.TransactionDetail = TransactionDetail;
	}

	private String getTransactionDetail() {
		return TransactionDetail;
	}
	
	private void setSendingAmount(Double SendingAmount) {
		this.SendingAmount = SendingAmount;
	}

	private Double getSendingAmount() {
		return SendingAmount;
	}
	private void setGiftCardInitialsPrice(Double GiftCardInitialsPrice) {
		this.GiftCardInitialsPrice = GiftCardInitialsPrice;
	}

	private Double getGiftCardInitialsPrice() {
		return GiftCardInitialsPrice;
	}
	private void setCharges(Double Charges) {
		this.Charges = Charges;
	}

	private Double getCharges() {
		return Charges;
	}

	private void setFees(Double Fees) {
		this.Fees = Fees;
	}

	private Double getFees() {
		return Fees;
	}

	private void setTax(Double Tax) {
		this.Tax = Tax;
	}

	private Double getTax() {
		return Tax;
	}

	private void setReceivingAmount(Double ReceivingAmount) {
		this.ReceivingAmount = ReceivingAmount;
	}

	private Double getReceivingAmount() {
		return ReceivingAmount;
	}

	private void setPaymentMethodId(int PaymentMethodId) {
		this.PaymentMethodId = PaymentMethodId;
	}

	private int getPaymentMethodId() {
		return PaymentMethodId;
	}

	private void setBeneficiaryId(int BeneficiaryId) {
		this.BeneficiaryId = BeneficiaryId;
	}

	private int getBeneficiaryId() {
		return BeneficiaryId;
	}

	private void setTransferPurpose(String TransferPurpose) {
		this.TransferPurpose = TransferPurpose;
	}

	private String getTransferPurpose() {
		return TransferPurpose;
	}

	private void setDeliveryType(String DeliveryType) {
		this.DeliveryType = DeliveryType;
	}

	private String getDeliveryType() {
		return DeliveryType;
	}

	private void setResult(String Result) {
		this.Result = Result;
	}

	private String getResult() {
		return Result;
	}

	private void setError(String Error) {
		this.Error = Error;
	}

	private String getError() {
		return Error;
	}

	public GiftCard addgftcard(int GiftCardid, int CompanyId, int CustomerId, String TransactionDetail,
			Double SendingAmount, Double Charges, Double Fees, Double Tax, Double ReceivingAmount, int BeneficiaryId,
			int PaymentMethodId, String TransferPurpose, String DeliveryType) {

		GiftCard _GiftCard = new GiftCard();

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();

		try {
			Double charge = 0.0;
			Double charge1 = 0.0;
			if (_Connection != null) {
				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM company where Company_Id='" + CompanyId + "'", _Connection);
				if (_ResultSet.next()) {

					ResultSet _ResultSetCustomer = _MYSQLHelper
							.GetResultSet("SELECT * FROM customer where customer_Id='" + CustomerId + "'", _Connection);
					if (_ResultSetCustomer.next()) {

						ResultSet _ResultSetpaymentMethod = _MYSQLHelper.GetResultSet(
								"SELECT * FROM paymentmethod where PaymentMethodId='" + PaymentMethodId + "'",
								_Connection);
						if (_ResultSetpaymentMethod.next()) {

							ResultSet _ResultGift = _MYSQLHelper.GetResultSet(
									"SELECT * FROM giftcard where GiftCardid='" + GiftCardid + "'", _Connection);
							if (_ResultGift.next()) {

								Double Giftcardamount = _ResultGift.getDouble("GiftCardPrice");
								charge=SendingAmount;
								ResultSet _ResultGiftTrans = _MYSQLHelper.GetResultSet(
										"SELECT COALESCE(SUM(SendingAmount),0) as SendingAmount FROM transactiondetails where GiftCardid='"
												+ GiftCardid + "'",
										_Connection);
								if (_ResultGiftTrans.next()) {
									charge1 = _ResultGiftTrans.getDouble("SendingAmount");
									charge = charge + charge1;

									if (charge <= Giftcardamount) {

										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										Calendar cal = Calendar.getInstance();
										String date = format.format(cal.getTime());
										_GiftCard.setGiftCardCreatedDate(date);
										// DestinationCountryId,
										// SourceCountryId, IsLive
										String Status = "Success";
										String PaymentGatewayResponse = "1";
										Random random = new Random();
										String PaymentGatewayTransactionId = String.format("%04d", random.nextInt(10000));
										//String PaymentGatewayTransactionId = "";
										int SendingCurrencyId = 3;
										int ReceivingCurrencytId = 3;
										int DestinationCountryId = 139;
										int SourceCountryId = 139;
										boolean IsLive = false;
										int ExchangeRate = 0;
										AuthrozieTranscation _AuthrozieTranscation = new AuthrozieTranscation();
										int _result = _AuthrozieTranscation.saveDataTranscationDetails(CompanyId,
												CustomerId, TransactionDetail, SendingAmount, Charges, Fees, Tax,
												_GiftCard.GiftCardCreatedDate, Status, PaymentGatewayResponse,
												PaymentGatewayTransactionId, SendingCurrencyId, ReceivingAmount,
												ReceivingCurrencytId, BeneficiaryId, PaymentMethodId,
												DestinationCountryId, SourceCountryId, IsLive, TransferPurpose,
												ExchangeRate, DeliveryType, _GiftCard.GiftCardCreatedDate);

										String sUpdateStatement = "UPDATE transactiondetails SET GiftCardid = ?"
												+ " WHERE TransactionId = ?";
										_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
										_PreparedStatement.setInt(1, GiftCardid);
										_PreparedStatement.setInt(2, _result);
										_PreparedStatement.executeUpdate();
										_GiftCard.setGiftCardid(GiftCardid);
										_GiftCard.setResult("Suceess");
									}
									else{
										_GiftCard.setResult("failed");
										_GiftCard.setError("Insufficient balance in gift card!");
									}
								}
							} else {
								_GiftCard.setResult("failed");
								_GiftCard.setError("Invalid Gift card Id!");
							}
						} else {
							_GiftCard.setResult("failed");
							_GiftCard.setError("Invalid payment MethodId!");
						}
					} else {
						_GiftCard.setResult("failed");
						_GiftCard.setError("Invalid CustomerId!");
					}

				} else {
					_GiftCard.setResult("failed");
					_GiftCard.setError("Invalid companyId!");
				}

			}
		} catch (

		Exception e) {

		}

		return _GiftCard;
	}
	
	
	public static ArrayList<GiftCard> getGiftCard() {
		
		
		ArrayList<GiftCard> _GiftCardlist = new ArrayList<GiftCard>();
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 try
			{
			 ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM giftcard",_Connection);
			 
			 while  (_ResultSet.next())
				{
				 GiftCard _GiftCard=new GiftCard();
				 _GiftCard.setGiftCardid(_ResultSet.getInt("GiftCardid"));
				 _GiftCard.setGiftCardName(_ResultSet.getString("GiftCardName"));
				 _GiftCard.setGiftCardPrice(_ResultSet.getDouble("GiftCardPrice"));
				 _GiftCard.setGiftCardInitialsPrice(_ResultSet.getDouble("InitialsPrice"));
				 _GiftCard.setGiftCardCreatedDate(_ResultSet.getString("GiftCardCreatedDate"));				 
				 _GiftCard.setResult("Success");
				 _GiftCardlist.add(_GiftCard);
				}
			 _ResultSet.close();
			}
		 catch (Exception e) {
			// TODO: handle exception
		}	
		
		return _GiftCardlist;
	}
	
	
	public GiftCard addgftcardVisa(int GiftCardid, int CompanyId, int CustomerId, String TransactionDetail,
			Double SendingAmount, Double Charges, Double Fees, Double Tax, Double ReceivingAmount, int BeneficiaryId,
			int PaymentMethodId, String TransferPurpose, String DeliveryType, String CardNumber,String setExpirationDate,String cvv, String SenderName) {

		GiftCard _GiftCard = new GiftCard();

		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		AuthrozieTranscation _AuthrozieTranscation = new AuthrozieTranscation();
		try {
			Double charge = 0.0;
			Double charge1 = 0.0;
			if (_Connection != null) {
				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM company where Company_Id='" + CompanyId + "'", _Connection);
				if (_ResultSet.next()) {

					ResultSet _ResultSetCustomer = _MYSQLHelper
							.GetResultSet("SELECT * FROM customer where customer_Id='" + CustomerId + "'", _Connection);
					if (_ResultSetCustomer.next()) {

						ResultSet _ResultSetpaymentMethod = _MYSQLHelper.GetResultSet(
								"SELECT * FROM paymentmethod where PaymentMethodId='" + PaymentMethodId + "'",
								_Connection);
						if (_ResultSetpaymentMethod.next()) {

							ResultSet _ResultGift = _MYSQLHelper.GetResultSet(
									"SELECT * FROM giftcard where GiftCardid='" + GiftCardid + "'", _Connection);
							if (_ResultGift.next()) {

								Double Giftcardamount = _ResultGift.getDouble("GiftCardPrice");
								charge=SendingAmount;
								ResultSet _ResultGiftTrans = _MYSQLHelper.GetResultSet(
										"SELECT COALESCE(SUM(SendingAmount),0) as SendingAmount FROM transactiondetails where GiftCardid='"
												+ GiftCardid + "'",
										_Connection);
								if (_ResultGiftTrans.next()) {
									charge1 = _ResultGiftTrans.getDouble("SendingAmount");
									charge = charge + charge1;

									if (charge <= Giftcardamount) {

										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										Calendar cal = Calendar.getInstance();
										String date = format.format(cal.getTime());
										_GiftCard.setGiftCardCreatedDate(date);
										// DestinationCountryId,
										// SourceCountryId, IsLive
										String Status = "Success";
										String PaymentGatewayResponse = "1";
										Random random = new Random();
										String PaymentGatewayTransactionId = String.format("%04d", random.nextInt(10000));
										//String PaymentGatewayTransactionId = "";
										int SendingCurrencyId = 3;
										int ReceivingCurrencytId = 3;
										int DestinationCountryId = 139;
										int SourceCountryId = 139;
										boolean IsLive = false;
										int ExchangeRate = 0;
										
										//
										
										double sAmounts = SendingAmount;
										
										MagicPay _MagicPay=new MagicPay();
										_MagicPay.PaymentMethodId = PaymentMethodId;
										_MagicPay.CompanyId = CompanyId;
										_MagicPay.CustomerId = CustomerId;
										_MagicPay.TransactionDetail = TransactionDetail;
										_MagicPay.SendingAmount = sAmounts;
										_MagicPay.Charges = 0.00;
										_MagicPay.Tax = 0.00;
										_MagicPay.SendingCurrencyId = 3;
										_MagicPay.ReceivingAmount = 0;
										_MagicPay.ReceivingCurrencytId = 3;
										_MagicPay.BeneficiaryId = 0;
										_MagicPay.TransferPurpose = "Bill Payment";
										_MagicPay.ExchangeRate = 0;
										_MagicPay.DeliveryType = "0";
										_MagicPay.CardNumber = CardNumber;
										_MagicPay.setExpirationDate = setExpirationDate;
										_MagicPay.cvv = cvv;
										_MagicPay.SenderName=SenderName;
										_MagicPay.addMagicPay(_MagicPay);
										if (_MagicPay.Result == "Success") {
											
											_AuthrozieTranscation.TransactionId = _MagicPay.TransactionId;
											String dPaymentGatewayTransactionId = _MagicPay.PaymentGatewayTransactionId
													.toString();
											
											
											
											/*int _result = _AuthrozieTranscation.saveDataTranscationDetails(CompanyId,
													CustomerId, TransactionDetail, SendingAmount, Charges, Fees, Tax,
													_GiftCard.GiftCardCreatedDate, Status, PaymentGatewayResponse,
													PaymentGatewayTransactionId, SendingCurrencyId, ReceivingAmount,
													ReceivingCurrencytId, BeneficiaryId, PaymentMethodId,
													DestinationCountryId, SourceCountryId, IsLive, TransferPurpose,
													ExchangeRate, DeliveryType, _GiftCard.GiftCardCreatedDate);
                                                */
											String sUpdateStatement = "UPDATE transactiondetails SET GiftCardid = ?"
													+ " WHERE TransactionId = ?";
											_PreparedStatement = _Connection.prepareStatement(sUpdateStatement);
											_PreparedStatement.setInt(1, GiftCardid);
											_PreparedStatement.setInt(2, _AuthrozieTranscation.TransactionId);
											_PreparedStatement.executeUpdate();
											_GiftCard.setGiftCardid(GiftCardid);
											_GiftCard.setPaymentGatewayTransactionId(dPaymentGatewayTransactionId);
											_GiftCard.setTransactionId(_AuthrozieTranscation.TransactionId);
											_GiftCard.setResult("Suceess");
										}
										//
										
										
										
										
									}
									else{
										_GiftCard.setResult("failed");
										_GiftCard.setError("Insufficient balance in gift card!");
									}
								}
							} else {
								_GiftCard.setResult("failed");
								_GiftCard.setError("Invalid Gift card Id!");
							}
						} else {
							_GiftCard.setResult("failed");
							_GiftCard.setError("Invalid payment MethodId!");
						}
					} else {
						_GiftCard.setResult("failed");
						_GiftCard.setError("Invalid CustomerId!");
					}

				} else {
					_GiftCard.setResult("failed");
					_GiftCard.setError("Invalid companyId!");
				}

			}
		} catch (

		Exception e) {

		}

		return _GiftCard;
	}
	
	
	
}
