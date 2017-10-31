package com.etl.base;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

import net.authorize.Environment;
import net.authorize.api.contract.v1.*;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.controller.base.ApiOperationBase;
import net.authorize.api.controller.CreateTransactionController;


public class AuthrozieTranscation {
	public int TransactionId;
	public int PaymentMethodId;
	public int CompanyId;
	public int CustomerId;
	public String TransactionDetail;
	public double SendingAmount;
	public double Charges;	
	public double Fees;
	public double Tax;
	public String TransactionDate;
	public String Status;
	public String PaymentGatewayResponse;
	public String PaymentGatewayTransactionId;
	
	
	public int SendingCurrencyId;
	public double ReceivingAmount;
	public int ReceivingCurrencytId;
	public int BeneficiaryId;
	public int SourceCountryId;
	public int DestinationCountryId;
	public boolean IsLive;
	
	public String TransferPurpose;
	public double ExchangeRate;
	public String DeliveryType;
	
	
	public String CardNumber;
	public String setExpirationDate;
	public String cvv;
	public String CreatedDate;
	public String Result;
	public String Error;
	
	
	
	
	
	private void setTransactionId(int TransactionId){
		this.TransactionId = TransactionId;
	}	
	private int getTransactionId(){
		return TransactionId;
	}
	
	private void setPaymentMethodId(int PaymentMethodId){
		this.PaymentMethodId = PaymentMethodId;
	}	
	private int getPaymentMethodId(){
		return PaymentMethodId;
	}
	
	private void setCompanyId(int CompanyId){
		this.CompanyId = CompanyId;
	}	
	private int getCompanyId(){
		return CompanyId;
	}
	private void setCustomerId(int CustomerId){
		this.CustomerId = CustomerId;
	}	
	private int getCustomerId(){
		return CustomerId;
	}
	
	
	private void setTransactionDetail(String TransactionDetail){
		this.TransactionDetail = TransactionDetail;
	}	
	private String getTransactionDetail(){
		return TransactionDetail;
	}
	
	private void setSendingAmount(double SendingAmount){
		this.SendingAmount = SendingAmount;
	}	
	private double getSendingAmount(){
		return SendingAmount;
	}
	
	
	
	private void setCharges(double Charges){
		this.Charges = Charges;
	}	
	private double getCharges(){
		return Charges;
	}
	
	private void setFees(double Fees){
		this.Fees = Fees;
	}	
	private double getFees(){
		return Fees;
	}
	private void setTax(double Tax){
		this.Tax = Tax;
	}	
	private double getTax(){
		return Tax;
	}
	
	
	private void setTransactionDate(String TransactionDate){
		this.TransactionDate = TransactionDate;
	}	
	private String getTransactionDate(){
		return TransactionDate;
	}
	
	
	
	private void setStatus(String Status){
		this.Status = Status;
	}	
	private String getStatus(){
		return Status;
	}
	private void setPaymentGatewayResponse(String PaymentGatewayResponse){
		this.PaymentGatewayResponse = PaymentGatewayResponse;
	}	
	private String getPaymentGatewayResponse(){
		return PaymentGatewayResponse;
	}
	
	
	private void setPaymentGatewayTransactionId(String PaymentGatewayTransactionId){
		this.PaymentGatewayTransactionId = PaymentGatewayTransactionId;
	}	
	private String getPaymentGatewayTransactionId(){
		return PaymentGatewayTransactionId;
	}
	
	
	private void setReceivingAmount(double ReceivingAmount){
		this.ReceivingAmount = ReceivingAmount;
	}	
	private double getReceivingAmount(){
		return ReceivingAmount;
	}
	
	private void setSendingCurrencyId(int SendingCurrencyId){
		this.SendingCurrencyId = SendingCurrencyId;
	}	
	private int getSendingCurrencyId(){
		return SendingCurrencyId;
	}
	
	private void setReceivingCurrencytId(int ReceivingCurrencytId){
		this.ReceivingCurrencytId = ReceivingCurrencytId;
	}	
	private int getReceivingCurrencytId(){
		return ReceivingCurrencytId;
	}
	private void setBeneficiaryId(int BeneficiaryId){
		this.BeneficiaryId = BeneficiaryId;
	}	
	private int getBeneficiaryId(){
		return BeneficiaryId;
	}
	
	
	private void setSourceCountryId(int SourceCountryId){
		this.SourceCountryId = SourceCountryId;
	}	
	private int getSourceCountryId(){
		return SourceCountryId;
	}
	
	
	private void setDestinationCountryId(int DestinationCountryId){
		this.DestinationCountryId = DestinationCountryId;
	}	
	private int getDestinationCountryId(){
		return DestinationCountryId;
	}
	
	private void setIsLive(boolean IsLive){
		this.IsLive = IsLive;
	}	
	private boolean getIsLive(){
		return IsLive;
	}
	
	private void setTransferPurpose(String TransferPurpose){
		this.TransferPurpose = TransferPurpose;
	}	
	private String getTransferPurpose(){
		return TransferPurpose;
	}
	
	private void setExchangeRate(double ExchangeRate){
		this.ExchangeRate = ExchangeRate;
	}	
	private double getExchangeRate(){
		return ExchangeRate;
	}
	
	
	private void setDeliveryType(String DeliveryType){
		this.DeliveryType = DeliveryType;
	}	
	private String getDeliveryType(){
		return DeliveryType;
	}
	
	private void setCardNumber(String CardNumber){
		this.CardNumber = CardNumber;
	}	
	private String getCardNumber(){
		return CardNumber;
	}
	
	private void setExpirationDate(String setExpirationDate){
		this.setExpirationDate = setExpirationDate;
	}	
	private String getExpirationDate(){
		return setExpirationDate;
	}
	
	private void setCreatedDate(String CreatedDate){
		this.CreatedDate = CreatedDate;
	}	
	private String getCreatedDate(){
		return CreatedDate;
	}
	
	private void setcvv(String cvv){
		this.cvv = cvv;
	}	
	private String getcvv(){
		return cvv;
	}
	
	
	private void setResult(String Result){
		this.Result = Result;
	}	
	private String getResult(){
		return Result;
	}
	private void setError(String Error){
		this.Error = Error;
	}	
	private String getError(){
		return Error;
	}
		

	 public AuthrozieTranscation addTranscation(AuthrozieTranscation _AuthrozieTranscation) {
		 
		 Connection _Connection = MYSQLConnection.GetConnection();
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			if(_Connection!=null)
			{
				try{
					 PreparedStatement _PreparedStatement = null;
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM authorizepaymentsettings where PaymentMethodId='"+_AuthrozieTranscation.PaymentMethodId+"'",_Connection);
					if(_ResultSet.next())
					{
						
						ResultSet _ResultSetcompany = _MYSQLHelper.GetResultSet("SELECT * FROM company where Company_Id='"+_AuthrozieTranscation.CompanyId+"'",_Connection);
						if (_ResultSetcompany.next())
						{	
							////ResultSet _ResultSetCustomer = _MYSQLHelper.GetResultSet("SELECT * FROM Customer where customer_Id='"+_AuthrozieTranscation.CustomerId+"'",_Connection);
							//if (_ResultSetCustomer.next())
							//{
								
								ResultSet _ResultSetSourceCountry = _MYSQLHelper.GetResultSet("SELECT * FROM currency where CurrencyId='"+_AuthrozieTranscation.SendingCurrencyId+"'",_Connection);
								if (_ResultSetSourceCountry.next())
								{
									_AuthrozieTranscation.setSourceCountryId(_ResultSetSourceCountry.getInt("country_id"));
								
									ResultSet _ResultSetDestinationCountry = _MYSQLHelper.GetResultSet("SELECT * FROM currency where CurrencyId='"+_AuthrozieTranscation.ReceivingCurrencytId+"'",_Connection);
									if (_ResultSetDestinationCountry.next())
									{
										_AuthrozieTranscation.setDestinationCountryId(_ResultSetSourceCountry.getInt("country_id"));
									
										  ApiOperationBase.setEnvironment(Environment.SANDBOX);
										  MerchantAuthenticationType merchantAuthenticationType  = new MerchantAuthenticationType() ;
										  String apiLoginId=_ResultSet.getString("MerchantLoginId");
										  String transactionKey=_ResultSet.getString("MerchantTransactionKey");
										  merchantAuthenticationType.setName(apiLoginId);
										  merchantAuthenticationType.setTransactionKey(transactionKey);
										  PaymentType paymentType = new PaymentType();
									      CreditCardType creditCard = new CreditCardType();
									      creditCard.setCardNumber(_AuthrozieTranscation.CardNumber);
									      creditCard.setExpirationDate(_AuthrozieTranscation.setExpirationDate);
									      creditCard.setCardCode(_AuthrozieTranscation.cvv);
									      paymentType.setCreditCard(creditCard);
									        TransactionRequestType txnRequest = new TransactionRequestType();
									        txnRequest.setTransactionType(TransactionTypeEnum.AUTH_ONLY_TRANSACTION.value());
									        txnRequest.setPayment(paymentType);
									        txnRequest.setAmount(new BigDecimal(_AuthrozieTranscation.SendingAmount).setScale(2, RoundingMode.CEILING));
									        
									        CreateTransactionRequest apiRequest = new CreateTransactionRequest();
									    	apiRequest.setMerchantAuthentication(merchantAuthenticationType);

									            apiRequest.setTransactionRequest(txnRequest);
									            CreateTransactionController controller = new CreateTransactionController(apiRequest);
									            controller.execute();
									            CreateTransactionResponse response = controller.getApiResponse();
									            
									            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
												Calendar cal = Calendar.getInstance();
												String date=format.format(cal.getTime());
												_AuthrozieTranscation.setCreatedDate(date);
												_AuthrozieTranscation.setTransactionDate(date);
					            if (response!=null) {
					            	
					            	// If API Response is ok, go ahead and check the transaction response
					            	if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
					            		TransactionResponse result = response.getTransactionResponse();
					            		if(result.getMessages() != null){
					            			System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
					            			//System.out.println("Response Code: " + result.getResponseCode());
					            			////System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
					            			//System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
					            			//System.out.println("Auth code: " + result.getAuthCode());
					            			
					            			
					            			//_AuthrozieTranscation.setResult(result.getMessages().getMessage().get(0).getDescription());
					            			
					            			
					            				_AuthrozieTranscation.setStatus("Success");
					            			
					            			_AuthrozieTranscation.setPaymentGatewayResponse(result.getResponseCode());
					            			_AuthrozieTranscation.setPaymentGatewayTransactionId(result.getTransId());
					            			
					            			_AuthrozieTranscation.setIsLive(false);
					            			
					            			String sInsertStatement = "INSERT INTO transactiondetails( CompanyId, CustomerId, TransactionDetail,SendingAmount,Charges,Fees,Tax, TransactionDate, Status,PaymentGatewayResponse,PaymentGatewayTransactionId,SendingCurrencyId,ReceivingAmount,ReceivingCurrencytId,BeneficiaryId,PaymentMethodId, DestinationCountryId, SourceCountryId,IsLive,TransferPurpose,ExchangeRate,DeliveryType,CreatedDate)";
					            			sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
					            			 _PreparedStatement = _Connection.prepareStatement(sInsertStatement);
											_PreparedStatement.setInt(1, _AuthrozieTranscation.CompanyId);							
											_PreparedStatement.setInt(2, _AuthrozieTranscation.CustomerId); 
											_PreparedStatement.setString(3, _AuthrozieTranscation.TransactionDetail); 
											_PreparedStatement.setDouble(4, _AuthrozieTranscation.SendingAmount); 
											_PreparedStatement.setDouble(5, _AuthrozieTranscation.Charges); 
											_PreparedStatement.setDouble(6, _AuthrozieTranscation.Fees); 
											_PreparedStatement.setDouble(7, _AuthrozieTranscation.Tax); 
											_PreparedStatement.setString(8, _AuthrozieTranscation.TransactionDate); 
											_PreparedStatement.setString(9, _AuthrozieTranscation.Status); 
											_PreparedStatement.setString(10, _AuthrozieTranscation.PaymentGatewayResponse); 
											_PreparedStatement.setString(11, _AuthrozieTranscation.PaymentGatewayTransactionId); 
											_PreparedStatement.setInt(12, _AuthrozieTranscation.SendingCurrencyId); 
											_PreparedStatement.setDouble(13, _AuthrozieTranscation.ReceivingAmount); 
											_PreparedStatement.setInt(14, _AuthrozieTranscation.ReceivingCurrencytId); 
											_PreparedStatement.setInt(15, _AuthrozieTranscation.BeneficiaryId); 
											_PreparedStatement.setInt(16, _AuthrozieTranscation.PaymentMethodId); 
											_PreparedStatement.setInt(17, _AuthrozieTranscation.DestinationCountryId); 
											_PreparedStatement.setInt(18, _AuthrozieTranscation.SourceCountryId); 
											_PreparedStatement.setBoolean(19, _AuthrozieTranscation.IsLive); 
											_PreparedStatement.setString(20, _AuthrozieTranscation.TransferPurpose); 
											_PreparedStatement.setDouble(21, _AuthrozieTranscation.ExchangeRate); 
											_PreparedStatement.setString(22, _AuthrozieTranscation.DeliveryType); 
											_PreparedStatement.setString(23, _AuthrozieTranscation.CreatedDate); 
											_PreparedStatement.executeUpdate();
											_AuthrozieTranscation.setResult("Sucess");
											ResultSet _ResultSetld = _MYSQLHelper.GetResultSet("SELECT MAX(TransactionId) AS TransactionId FROM transactiondetails",_Connection);
											if (_ResultSetld.next()){
											int lastid = _ResultSetld.getInt("TransactionId");								
											_AuthrozieTranscation.setTransactionId(lastid);}
											clear(_AuthrozieTranscation);
					            		}
					            		else {
					            			//System.out.println("Failed Transaction.");
					            			if(response.getTransactionResponse().getErrors() != null){
					            			//	System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
					            				//System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
					            				_AuthrozieTranscation.setResult("failed");
					            				_AuthrozieTranscation.setError("Failed Transaction!");
					            				clear(_AuthrozieTranscation);
					            			}
					            		}
					            	}
					            	else {
					            		//System.out.println("Failed Transaction.");
					            		if(response.getTransactionResponse() != null && response.getTransactionResponse().getErrors() != null){
					            			//System.out.println("Error Code: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
					            			//System.out.println("Error message: " + response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
					            			_AuthrozieTranscation.setResult("failed");
				            				_AuthrozieTranscation.setError("Invalid api Login Id!");
				            				clear(_AuthrozieTranscation);
					            		}
					            		else {
					            			//System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
					            			//System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
					            			_AuthrozieTranscation.setResult("failed");
					            			_AuthrozieTranscation.setError("Failed Transaction!");
					            			clear(_AuthrozieTranscation);
					            		}
					            	}
					            }
					            else {
					            	//System.out.println("Null Response.");
					            	_AuthrozieTranscation.setResult("failed");
				    				_AuthrozieTranscation.setError("Invalid transaction Key!");
				    				clear(_AuthrozieTranscation);
					            }
									}
									else {
						            	//System.out.println("Null Response.");
						            	_AuthrozieTranscation.setResult("failed");
					    				_AuthrozieTranscation.setError("Invalid Destination Country Id!");
					    				clear(_AuthrozieTranscation);
						            }
									
								}
								 else {
						            	//System.out.println("Null Response.");
						            	_AuthrozieTranscation.setResult("failed");
					    				_AuthrozieTranscation.setError("Invalid Source Country Id!");
					    				clear(_AuthrozieTranscation);
						            }
							//}
							// else {
					            	//System.out.println("Null Response.");
					          //  	_AuthrozieTranscation.setResult("failed");
				    			////	_AuthrozieTranscation.setError("Invalid Customer Id!");
				    			//	clear(_AuthrozieTranscation);
					           // }
						}
						 else {
				            	//System.out.println("Null Response.");
				            	_AuthrozieTranscation.setResult("failed");
			    				_AuthrozieTranscation.setError("Invalid Company Id!");
			    				clear(_AuthrozieTranscation);
				            }
					            
					}
					 else {
			            	//System.out.println("Null Response.");
			            	_AuthrozieTranscation.setResult("failed");
		    				_AuthrozieTranscation.setError("Invalid Payment Method Id!");
		    				clear(_AuthrozieTranscation);
			            }
				
				}
				catch (Exception e) {
					clear(_AuthrozieTranscation);
				}
			}
			
		
		  
		 return _AuthrozieTranscation;
	 }
	 
	 
	 public static ArrayList<AuthrozieTranscation> getAuthrozieTranscationDetails(int CustomerId) {
			Connection _Connection = MYSQLConnection.GetConnection();
			
			ArrayList<AuthrozieTranscation> _AuthrozieTranscationDetaillist = new ArrayList<AuthrozieTranscation>();
			
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			 try
				{
				 if(_Connection!=null)			
				
					{
					
					ResultSet _ResultSet = _MYSQLHelper.GetResultSet("SELECT * FROM transactiondetails where CustomerId='"+CustomerId+"'",_Connection);
					
						while  (_ResultSet.next())
						{
							
							AuthrozieTranscation _AuthrozieTranscation=new AuthrozieTranscation();
							_AuthrozieTranscation.setTransactionId(_ResultSet.getInt("TransactionId"));
							_AuthrozieTranscation.setCompanyId(_ResultSet.getInt("CompanyId"));
							_AuthrozieTranscation.setCustomerId(_ResultSet.getInt("CustomerId"));
							_AuthrozieTranscation.setTransactionDetail(_ResultSet.getString("TransactionDetail"));
							_AuthrozieTranscation.setSendingAmount(_ResultSet.getDouble("SendingAmount"));						
							_AuthrozieTranscation.setCharges(_ResultSet.getDouble("Charges"));
							_AuthrozieTranscation.setFees(_ResultSet.getDouble("Fees"));
							_AuthrozieTranscation.setTax(_ResultSet.getDouble("Tax"));
							_AuthrozieTranscation.setCreatedDate(_ResultSet.getString("TransactionDate"));
							
							_AuthrozieTranscation.setStatus(_ResultSet.getString("Status"));
							_AuthrozieTranscation.setPaymentGatewayResponse(_ResultSet.getString("PaymentGatewayResponse"));
							_AuthrozieTranscation.setPaymentGatewayTransactionId(_ResultSet.getString("PaymentGatewayTransactionId"));
							_AuthrozieTranscation.setSendingCurrencyId(_ResultSet.getInt("SendingCurrencyId"));
							_AuthrozieTranscation.setReceivingAmount(_ResultSet.getDouble("ReceivingAmount"));
							_AuthrozieTranscation.setReceivingCurrencytId(_ResultSet.getInt("ReceivingCurrencytId"));
							_AuthrozieTranscation.setBeneficiaryId(_ResultSet.getInt("BeneficiaryId"));
							_AuthrozieTranscation.setPaymentMethodId(_ResultSet.getInt("PaymentMethodId"));
							_AuthrozieTranscation.setDestinationCountryId(_ResultSet.getInt("DestinationCountryId"));
							_AuthrozieTranscation.setSourceCountryId(_ResultSet.getInt("SourceCountryId"));
							_AuthrozieTranscation.setIsLive(_ResultSet.getBoolean("IsLive"));
							_AuthrozieTranscation.setTransferPurpose(_ResultSet.getString("TransferPurpose"));
							_AuthrozieTranscation.setExchangeRate(_ResultSet.getDouble("ExchangeRate"));
							_AuthrozieTranscation.setDeliveryType(_ResultSet.getString("DeliveryType"));
							_AuthrozieTranscation.setCreatedDate(_ResultSet.getString("CreatedDate"));
							_AuthrozieTranscation.setResult("Success");
							_AuthrozieTranscationDetaillist.add(_AuthrozieTranscation);
							
						}
						 _ResultSet.close();
					
					 
					}
				
					
				}
			 catch(Exception e){
				 e.printStackTrace();
			 }
			 finally {
				
					if (_Connection != null) {
						try {
							_Connection.close();
						} catch (SQLException e) {
							//logger.error(e.getMessage() + " Stack Trace: " + e.getStackTrace());
						}
					}
				}	
			
			return _AuthrozieTranscationDetaillist;
		}
	 
	 
	 
	 
	 private AuthrozieTranscation clear(AuthrozieTranscation _AuthrozieTranscation) {
		 _AuthrozieTranscation.setPaymentMethodId(0);
		 _AuthrozieTranscation.setCompanyId(0);
		 _AuthrozieTranscation.setCustomerId(0);
		 _AuthrozieTranscation.setTransactionDetail("");
		 _AuthrozieTranscation.setSendingAmount(0);
		 _AuthrozieTranscation.setCharges(0);
		 _AuthrozieTranscation.setFees(0);
		 _AuthrozieTranscation.setTax(0);
		 _AuthrozieTranscation.setStatus("");
		 _AuthrozieTranscation.setPaymentGatewayResponse("");
		 _AuthrozieTranscation.setPaymentGatewayTransactionId("");
		 _AuthrozieTranscation.setSendingCurrencyId(0);
		 _AuthrozieTranscation.setReceivingAmount(0);
		 _AuthrozieTranscation.setReceivingCurrencytId(0);
		 _AuthrozieTranscation.setBeneficiaryId(0);
		 _AuthrozieTranscation.setSourceCountryId(0);
		 _AuthrozieTranscation.setDestinationCountryId(0);
		 _AuthrozieTranscation.setTransferPurpose("");
		 _AuthrozieTranscation.setExchangeRate(0);
		 _AuthrozieTranscation.setDeliveryType("");
		 _AuthrozieTranscation.setCardNumber("");
		 _AuthrozieTranscation.setExpirationDate("");
		 _AuthrozieTranscation.setcvv("");
		 
		 return _AuthrozieTranscation;
	}
	 
}