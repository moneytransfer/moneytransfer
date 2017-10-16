
package com.moneytransfer;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;

import com.etl.base.CompanyDetail;
import com.etl.base.CountryDeatils;
import com.etl.base.CustomerDetail;
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
    public UserDetail updateCompany(UserDetail usersdetails) {
       return new UserDetail().updateUserDetail(usersdetails);
    }
    
    @POST
    @Path("getuser")    
    @Produces("application/json")
    public UserDetail getUser(UserDetail _UserDetail) {
      return new UserDetail().getUserDetail(_UserDetail);
    }
    
    @GET
    @Path("getuserdetails")    
    @Produces("application/json")
    public ArrayList<UserDetail> getUsersDetails() {
    	
      return UserDetail.getUserDetails();
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
    	
      return CustomerDetail.getCustomerDetails(_CustomerDetail);
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
}
