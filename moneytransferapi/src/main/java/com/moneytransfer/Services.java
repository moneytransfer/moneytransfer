
package com.moneytransfer;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.etl.base.companydetails;
import com.etl.base.usersdetails;




@Path("/")
public class Services {
        
    @GET 
    @Path("myresource")    
    @Produces("text/plain")
    public String getIt() {
        return "Hi welcome to Money Transfer api's!";
    }
    @POST 
    @Path("addCompany")    
    @Produces("application/json")
    public companydetails AddCompany(companydetails _companydetails) {
       return new companydetails().addcompany(_companydetails);
    }

    @POST 
    @Path("updateCompany")    
    @Produces("application/json")
    public companydetails updateCompany(companydetails _companydetails) {
       return new companydetails().updatecompany(_companydetails);
    }
    
    @POST 
    @Path("deleteCompany")    
    @Produces("application/json")
    public companydetails deleteCompany(companydetails _companydetails) {
       return new companydetails().deletecompany(_companydetails);
    }
    
    @POST
    @Path("authenticateCompany")    
    @Produces("application/json")
    public companydetails loginCompany(companydetails _companydetails) {
       return new companydetails().logincompany(_companydetails);
    }
    
    
    @POST 
    @Path("adduser")    
    @Produces("application/json")
    public usersdetails Addusers(usersdetails _usersdetails) {
       return new usersdetails().adduser(_usersdetails);
    }
    
    @POST
    @Path("authenticateusers")    
    @Produces("application/json")
    public usersdetails loginCompany(usersdetails _usersdetails) {
       return new usersdetails().loginuser(_usersdetails);
    }
    
    @POST 
    @Path("deleteuser")    
    @Produces("application/json")
    public usersdetails deleteCompany(usersdetails _usersdetails) {
       return new usersdetails().deleteusers(_usersdetails);
    }
    
    @POST 
    @Path("updateusers")    
    @Produces("application/json")
    public usersdetails updateCompany(usersdetails usersdetails) {
       return new usersdetails().updateusersdetails(usersdetails);
    }
}
