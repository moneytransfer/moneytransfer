
package com.moneytransfer;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.etl.base.AgentDetails;
import com.etl.base.AuthorizePaymentDetails;
import com.etl.base.AuthrozieTranscation;
import com.etl.base.BeneficiaryDetails;
import com.etl.base.BeneficiaryType;
import com.etl.base.BillPay;
import com.etl.base.CarrierInfoByMobileNumber;
import com.etl.base.CompanyDetail;
import com.etl.base.CountryDeatils;
import com.etl.base.Currency;
import com.etl.base.CurrencyConversion;
import com.etl.base.CustomerDetail;
import com.etl.base.FeesCategory;
import com.etl.base.GlobalExchangeRate;
import com.etl.base.MagicPay;
import com.etl.base.MagicTest;
import com.etl.base.PaymentFees;
import com.etl.base.PaymentMethod;
import com.etl.base.PaymentType;
import com.etl.base.TransactionFeeSharing;
import com.etl.base.UserDetail;

@Path("/")
public class Services {

	@GET
	@Path("verifyservice")
	@Produces("text/plain")
	public String getIt() {
		return "Welcome to Money Transfer APIs!";
	}

	@POST
	@Path("addcompany")
	@Produces("application/json")
	public CompanyDetail AddCompany(CompanyDetail _companydetails) {
		return new CompanyDetail().addCompany(_companydetails);
	}

	@POST
	@Path("updatecompany")
	@Produces("application/json")
	public CompanyDetail updateCompany(CompanyDetail _companydetails) {
		return new CompanyDetail().updateCompany(_companydetails);
	}

	@POST
	@Path("deletecompany")
	@Produces("application/json")
	public CompanyDetail deleteCompany(CompanyDetail _companydetails) {
		return new CompanyDetail().deleteCompany(_companydetails);
	}

	@POST
	@Path("getcompany")
	@Produces("application/json")
	public CompanyDetail getUser(CompanyDetail _CompanyDetail) {
		return new CompanyDetail().getCompany(_CompanyDetail);
	}

	@GET
	@Path("getcompanydetails")
	@Produces("application/json")
	public ArrayList<CompanyDetail> getCompanyDetails() {

		return CompanyDetail.getCompanyDetails();
	}

	@POST
	@Path("adduser")
	@Produces("application/json")
	public UserDetail Addusers(UserDetail _usersdetails) {
		return new UserDetail().addUser(_usersdetails);
	}

	@POST
	@Path("authenticateuser")
	@Produces("application/json")
	public UserDetail loginCompany(UserDetail _usersdetails) {
		return new UserDetail().loginUser(_usersdetails);
	}

	@POST
	@Path("deleteuser")
	@Produces("application/json")
	public UserDetail deleteCompany(UserDetail _usersdetails) {
		return new UserDetail().deleteUser(_usersdetails);
	}

	@POST
	@Path("updateuser")
	@Produces("application/json")
	public UserDetail updateuser(UserDetail usersdetails) {
		return new UserDetail().updateUserDetail(usersdetails);
	}

	@POST
	@Path("getuser")
	@Produces("application/json")
	public UserDetail getUser(UserDetail _UserDetail) {
		return new UserDetail().getUserDetail(_UserDetail);
	}

	@POST
	@Path("getuserdetails")
	@Produces("application/json")
	public ArrayList<UserDetail> getUsersDetails(UserDetail _UserDetail) {

		return UserDetail.getUserDetails(_UserDetail.CompanyId);
	}

	@POST
	@Path("getcountry")
	@Produces("application/json")
	public CountryDeatils getUser(CountryDeatils _CountryDeatils) {
		return new CountryDeatils().getCountry(_CountryDeatils);
	}

	@GET
	@Path("getcountrydetails")
	@Produces("application/json")
	public ArrayList<CountryDeatils> getcountryDetails() {

		return CountryDeatils.getCountryDetails();
	}

	@POST
	@Path("getcountryByPhoneCode")
	@Produces("application/json")
	public CountryDeatils getcountryByIso(CountryDeatils _CountryDeatils) {
		return new CountryDeatils().getCountryDetailsIso(_CountryDeatils.phonecode,_CountryDeatils.CountryName);
	}

	@POST
	@Path("savecustomer")
	@Produces("application/json")
	public CustomerDetail addcustomer(CustomerDetail _CustomerDetail) {
		return new CustomerDetail().addCustomer(_CustomerDetail);
	}

	@POST
	@Path("getcustomerbycompanyid")
	@Produces("application/json")
	public ArrayList<CustomerDetail> getcustomerDetailsByCompanyId(CustomerDetail _CustomerDetail) {

		return CustomerDetail.getCustomerDetails(_CustomerDetail.CompanyId);
	}

	@POST
	@Path("authenticatecustomer")
	@Produces("application/json")
	public CustomerDetail authenticatecustomer(CustomerDetail _CustomerDetail) {
		return new CustomerDetail().loginCustomer(_CustomerDetail);
	}

	@POST
	@Path("getcustomerdetails")
	@Produces("application/json")
	public CustomerDetail getcustomer(CustomerDetail _CustomerDetail) {
		return new CustomerDetail().getCustomerDetail(_CustomerDetail);
	}

	@POST
	@Path("deletecustomer")
	@Produces("application/json")
	public CustomerDetail deletecustomer(CustomerDetail _CustomerDetail) {
		return new CustomerDetail().deleteCustomer(_CustomerDetail);
	}

	@POST
	@Path("aa")
	@Produces("application/json")
	public CustomerDetail email(CustomerDetail _CustomerDetail) {
		return new CustomerDetail().email(_CustomerDetail);
	}

	@POST
	@Path("savepaymenttype")
	@Produces("application/json")
	public PaymentType savePaymentType(PaymentType _PaymentType) {
		return new PaymentType().savepaymenttype(_PaymentType);
	}

	@GET
	@Path("getpaymenttypedetails")
	@Produces("application/json")
	public ArrayList<PaymentType> getPaymentTypeDetails() {

		return PaymentType.getPaymentTypeDetails();
	}

	@POST
	@Path("savepaymentmethod")
	@Produces("application/json")
	public PaymentMethod savePaymentMethod(PaymentMethod _PaymentMethod) {
		return new PaymentMethod().addPaymentMethod(_PaymentMethod);
	}

	@POST
	@Path("getpaymentmethodbycompanyid")
	@Produces("application/json")
	public ArrayList<PaymentMethod> getpaymentMethodByCompanyId(PaymentMethod _PaymentMethod) {

		return PaymentMethod.getPaymentMethodDetails(_PaymentMethod.CompanyId);
	}
	
	@POST
	@Path("getpaymentmethodbycompany")
	@Produces("application/json")
	public ArrayList<PaymentMethod> getpaymentmethodbycompany(PaymentMethod _PaymentMethod) {

		return PaymentMethod.getPaymentMethodDetailsforAdmin(_PaymentMethod.CompanyId);
	}

	@POST
	@Path("getpaymentmethoddetails")
	@Produces("application/json")
	public PaymentMethod getpaymentmethoddetails(PaymentMethod _PaymentMethod) {
		return new PaymentMethod().getPaymentMethodById(_PaymentMethod);
	}

	@POST
	@Path("deletepaymentmethod")
	@Produces("application/json")
	public PaymentMethod deletepaymentmethod(PaymentMethod _PaymentMethod) {
		return new PaymentMethod().deletePaymentMethod(_PaymentMethod);
	}

	@POST
	@Path("saveauthorizepayment")
	@Produces("application/json")
	public AuthorizePaymentDetails saveauthorizepayment(AuthorizePaymentDetails _AuthorizePaymentDetails) {
		return new AuthorizePaymentDetails().addAuthorizePayment(_AuthorizePaymentDetails);
	}

	@POST
	@Path("getauthorizepaymentdetails")
	@Produces("application/json")
	public AuthorizePaymentDetails getauthorizepaymentdetails(AuthorizePaymentDetails _AuthorizePaymentDetails) {
		return new AuthorizePaymentDetails().getAuthorizePaymentById(_AuthorizePaymentDetails);
	}

	@POST
	@Path("deleteauthorizepaymentdetails")
	@Produces("application/json")
	public AuthorizePaymentDetails deleteauthorizepaymentdetails(AuthorizePaymentDetails _AuthorizePaymentDetails) {
		return new AuthorizePaymentDetails().deleteAuthorizePaymentById(_AuthorizePaymentDetails);
	}

	@POST
	@Path("getauthorizepaymentdsettingsbypaymentmethodid")
	@Produces("application/json")
	public AuthorizePaymentDetails getauthorizepaymentdsettingsbypaymentmethodid(
			AuthorizePaymentDetails _AuthorizePaymentDetails) {
		return new AuthorizePaymentDetails().getAuthorizePaymentDetailsbyPaymentMethodId(_AuthorizePaymentDetails);
	}

	@GET
	@Path("getcurrencydetails")
	@Produces("application/json")
	public ArrayList<Currency> getCurrencyDetails() {

		return Currency.getCurrencyetails();
	}

	@GET
	@Path("getbeneficiarytypedetails")
	@Produces("application/json")
	public ArrayList<BeneficiaryType> getBeneficiaryTypeDetails() {

		return BeneficiaryType.getBeneficiaryTypeDetails();
	}

	@POST
	@Path("addbeneficiary")
	@Produces("application/json")
	public BeneficiaryDetails addbeneficiary(BeneficiaryDetails _BeneficiaryDetails) {
		return new BeneficiaryDetails().addBeneficiaryDetails(_BeneficiaryDetails);
	}

	@POST
	@Path("getbeneficiarydetails")
	@Produces("application/json")
	public ArrayList<BeneficiaryDetails> getBeneficiaryDetailsDetails(BeneficiaryDetails _BeneficiaryDetails) {

		return BeneficiaryDetails.getBeneficiaryDetails(_BeneficiaryDetails.CustomerId);
	}

	@POST
	@Path("getbeneficiarydetailsbyId")
	@Produces("application/json")
	public BeneficiaryDetails getbeneficiarydetailsbyId(BeneficiaryDetails _BeneficiaryDetails) {
		return new BeneficiaryDetails().getBeneficiaryDetailsById(_BeneficiaryDetails);
	}

	@POST
	@Path("deletebeneficiarydetail")
	@Produces("application/json")
	public BeneficiaryDetails deletebeneficiarydetail(BeneficiaryDetails _BeneficiaryDetails) {
		return new BeneficiaryDetails().deleteBeneficiaryDetails(_BeneficiaryDetails);
	}

	@POST
	@Path("makePayment")
	@Produces("application/json")
	public AuthrozieTranscation addAuthroziepayment(AuthrozieTranscation _AuthrozieTranscation) {
		return new AuthrozieTranscation().addTranscation(_AuthrozieTranscation);
	}

	@POST
	@Path("gettranscationdetails")
	@Produces("application/json")
	public ArrayList<AuthrozieTranscation> getBeneficiaryDetailsDetails(AuthrozieTranscation _AuthrozieTranscation) {

		return AuthrozieTranscation.getAuthrozieTranscationDetails(_AuthrozieTranscation.CustomerId);
	}

	@POST
	@Path("addPaymentFees")
	@Produces("application/json")
	public PaymentFees getBeneficiaryDetailsDetails(PaymentFees _PaymentFees) {

		return new PaymentFees().addPaymentFees(_PaymentFees);
	}

	@POST
	@Path("getPaymentFeesById")
	@Produces("application/json")
	public PaymentFees getPaymentFeesById(PaymentFees _PaymentFees) {

		return new PaymentFees().getPaymentFeesById(_PaymentFees);
	}

	@POST
	@Path("getPaymentFeesDetails")
	@Produces("application/json")
	public ArrayList<PaymentFees> getPaymentFeesBy(PaymentFees _PaymentFees) {

		return  PaymentFees.getPaymentFeesDetailsByCompany(_PaymentFees.CompanyId);
	}
	@POST
	@Path("getPaymentFeesByCompanydestinationCountry")
	@Produces("application/json")
	public ArrayList<PaymentFees> getPaymentFeesDetailsByCompanydestinationCountry(PaymentFees _PaymentFees) {

		return  PaymentFees.getPaymentFeesCompanyDestinationCountryDetails(_PaymentFees.CompanyId,_PaymentFees.DestinationCountry);
	}

	@POST
	@Path("deletePaymentFeesById")
	@Produces("application/json")
	public PaymentFees deletePaymentFeesById(PaymentFees _PaymentFees) {

		return new PaymentFees().deletePaymentFeesById(_PaymentFees);
	}

	@POST
	@Path("billPay")
	@Produces("application/json")
	public BillPay billPay(BillPay _BillPay) {
		return new BillPay().billpayment(_BillPay);
	}

	@POST
	@Path("getBillPayDetails")
	@Produces("application/json")
	public ArrayList<BillPay> getBillPayDetails(BillPay _BillPay) {

		return BillPay.getBillPayDetails(_BillPay.CustomerId);
	}

	@POST
	@Path("getCarrierInfoByMobileNumber")
	@Produces("application/json")
	public CarrierInfoByMobileNumber billPay(CarrierInfoByMobileNumber _CarrierInfoByMobileNumber) {
		return new CarrierInfoByMobileNumber().getCarrierInfoByMobileNumber(_CarrierInfoByMobileNumber);
	}

	@POST
	@Path("test")
	@Produces("application/json")
	public CurrencyConversion test(CurrencyConversion _CurrencyConversion) {
		return new CurrencyConversion().getCurrencyConversion(_CurrencyConversion);
	}

	@POST
	@Path("magicPay")
	@Produces("application/json")
	public MagicPay magicPay(MagicPay _MagicPay) {
		return new MagicPay().addMagicPay(_MagicPay);
	}

	@POST
	@Path("magicPayDetailsByCustomerId")
	@Produces("application/json")
	public ArrayList<MagicPay> getmagicPayDetailsByCustomerId(MagicPay _MagicPay) {
		return MagicPay.getMagicPayDetails(_MagicPay.CustomerId);
	}
	
	@POST
	@Path("magicPayDetailsByCompanyId")
	@Produces("application/json")
	public ArrayList<MagicPay> getmagicPayDetailsByCompanyId(MagicPay _MagicPay) {
		return MagicPay.getMagicPayDetailsByCompanyId(_MagicPay.CompanyId);
	}
	
	
	@POST
	@Path("agent")
	@Produces("application/json")
	public AgentDetails agent(AgentDetails _AgentDetails) {
		return new AgentDetails().addeditAgentDetails(_AgentDetails);
	}
	@POST
	@Path("getAgentdetailsById")
	@Produces("application/json")
	public ArrayList<AgentDetails> getAgentdetailsById(AgentDetails _AgentDetails) {
		return AgentDetails.getAgentDetails(_AgentDetails.AgentId);
	}
	
	@POST
	@Path("getAgentdetailsByCompanyId")
	@Produces("application/json")
	public ArrayList<AgentDetails> getAgentdetailsByCompanyId(AgentDetails _AgentDetails) {
		return AgentDetails.getAgentDetailsByCompanyId(_AgentDetails.CompanyId);
	}
	
	@POST
	@Path("deleteAgent")
	@Produces("application/json")
	public AgentDetails deleteAgent(AgentDetails _AgentDetails) {
		return new AgentDetails().deleteAgentDetails(_AgentDetails);
	}
	
	@POST
	@Path("getTranscationdetailsById")
	@Produces("application/json")
	public ArrayList<AuthrozieTranscation> getAgentdetailsByCompanyId(AuthrozieTranscation _AuthrozieTranscation) {
		return AuthrozieTranscation.getAuthrozieTranscationById(_AuthrozieTranscation.TransactionId);
	}
	
	@POST
	@Path("magicTest")
	@Produces("application/json")
	public MagicTest magicPay(MagicTest _MagicPay) {
		return new MagicTest().atest(_MagicPay);
	}
	
	@POST
	@Path("addTransactionFeeSharing")
	@Produces("application/json")
	public TransactionFeeSharing addTransactionFeeSharing(TransactionFeeSharing _TransactionFeeSharing) {
		return new TransactionFeeSharing().addupdateTransactionFeeSharing(_TransactionFeeSharing);
	}
	@POST
	@Path("getTransactionFeeSharingByComapny")
	@Produces("application/json")
	public ArrayList<TransactionFeeSharing> getTransactionFeeSharingByComapny(TransactionFeeSharing _TransactionFeeSharing) {
		return TransactionFeeSharing.getTransactionFeeSharingDetailsByCompany(_TransactionFeeSharing.CompanyId);
	}
	
	
	@POST
	@Path("getTransactionFeeSharingById")
	@Produces("application/json")
	public TransactionFeeSharing getTransactionFeeSharingById(TransactionFeeSharing _TransactionFeeSharing) {
		return new TransactionFeeSharing().gettransactionFeeSharing(_TransactionFeeSharing.TransactionFeeSharingId);
	}
	
	@POST
	@Path("deleteTransactionFeeSharingById")
	@Produces("application/json")
	public TransactionFeeSharing deleteTransactionFeeSharingById(TransactionFeeSharing _TransactionFeeSharing) {
		return new TransactionFeeSharing().deletetransactionFeeSharingById(_TransactionFeeSharing);
	}
	
	@POST
	@Path("globalExchangerate")
	@Produces("application/json")
	public GlobalExchangeRate addGlobalExchange(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate().addupdateGlobalExchangeRateDetails(_GlobalExchangeRate);
	}
	@GET
	@Path("getglobalExchangerateByComapny")
	@Produces("application/json")
	public ArrayList<GlobalExchangeRate> getglobalExchangerateByComapny() {
		return GlobalExchangeRate.getGlobalExchangeRateDetailsByCompany();
	}
	
	@POST
	@Path("globalExchangerateById")
	@Produces("application/json")
	public GlobalExchangeRate globalExchangerateById(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate().getGlobalExchangeRate(_GlobalExchangeRate.GlobalExchangeId);
	}
	
	@POST
	@Path("deleteglobalExchangerateById")
	@Produces("application/json")
	public GlobalExchangeRate deleteglobalExchangerateById(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate().deleteGlobalExchangeRate(_GlobalExchangeRate.GlobalExchangeId);
	}
	
	@POST
	@Path("globalExchangerateFees")
	@Produces("application/json")
	public PaymentFees globalExchangerateFees(PaymentFees _PaymentFees) {
		return new PaymentFees().getPaymentFeesnewdetails(_PaymentFees);
	}
	
	
	@POST
	@Path("enableDisableTransactionFeeSharing")
	@Produces("application/json")
	public TransactionFeeSharing enableDisableTransactionFeeSharing(TransactionFeeSharing _TransactionFeeSharing) {
		return new TransactionFeeSharing()._updateTransactionFeeSharingEnableDisable(_TransactionFeeSharing.TransactionFeeSharingId, _TransactionFeeSharing.IsSpecific);
	}
	
	
	@POST
	@Path("enableDisableglobalExchangerate")
	@Produces("application/json")
	public GlobalExchangeRate enableDisableglobalExchangerate(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate().updateDataGlobalExchangeRateEnableDisable(_GlobalExchangeRate.GlobalExchangeId, _GlobalExchangeRate.IsActive);
	}
	
	@POST
	@Path("updateRealfeesglobalExchangerate")
	@Produces("application/json")
	public GlobalExchangeRate updateRealfeesglobalExchangerate(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate().updateRealdataFeedGlobalExchangeRate(_GlobalExchangeRate.DestinationCountryId, _GlobalExchangeRate.SellSpotPrice);
	}
	
	@POST
	@Path("getFeesCategoryById")
	@Produces("application/json")
	public FeesCategory getFeesCategoryById(FeesCategory _FeesCategory) {
		return new FeesCategory()._getFeesCategoryById(_FeesCategory.FeesCategoryId);
	}
	
	@GET
	@Path("getFeesCategoryDetails")
	@Produces("application/json")
	public ArrayList<FeesCategory> getFeesCategoryDetails() {
		return FeesCategory._getFeesCategoryDetails();
	}
	
	@POST
	@Path("updateglobalExchangerateFees")
	@Produces("application/json")
	public GlobalExchangeRate updateglobalExchangerateFees(GlobalExchangeRate _GlobalExchangeRate) {
		return new GlobalExchangeRate()._updateGlobalExchangeRateFees(_GlobalExchangeRate.GlobalExchangeId, _GlobalExchangeRate.AutoFees,_GlobalExchangeRate.PaymentFeesId);
	}
	
	
	@POST
	@Path("getPaymentFeesDetailsByPaymentMethod")
	@Produces("application/json")
	public ArrayList<PaymentFees> getPaymentFeesDetailsByPaymentMethod(PaymentFees _PaymentFees) {

		return  PaymentFees.getPaymentFeesDetailsByPaymentMethod(_PaymentFees.PaymentMethodId,_PaymentFees.FeesCategoryId);
	}
}
