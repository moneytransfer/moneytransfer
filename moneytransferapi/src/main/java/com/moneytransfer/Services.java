
package com.moneytransfer;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;

import com.etl.base.AuthorizePaymentDetails;
import com.etl.base.CompanyDetail;
import com.etl.base.CountryDeatils;
import com.etl.base.CustomerDetail;
import com.etl.base.PaymentMethod;
import com.etl.base.PaymentType;
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
    public AuthorizePaymentDetails getauthorizepaymentdsettingsbypaymentmethodid(AuthorizePaymentDetails _AuthorizePaymentDetails) {
      return new AuthorizePaymentDetails().getAuthorizePaymentDetailsbyPaymentMethodId(_AuthorizePaymentDetails);
    }
}
