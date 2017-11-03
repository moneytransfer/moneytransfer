package com.etl.base;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.model.Charge;
public class StripeTest {

	public String apiKey;
	
	private void setapiKey(String apiKey){
		this.apiKey = apiKey;
	}	
	private String getapiKey(){
		return apiKey;
	}
	public StripeTest main(StripeTest _StripeTest)
	{
		Stripe.apiKey = _StripeTest.apiKey;
		final Map<String, Object> cardParams = new HashMap<String, Object>();
		 cardParams.put("number", "4242424242424242");
		    cardParams.put("exp_month", 12);
		    cardParams.put("exp_year", 2015);
		    cardParams.put("cvc", "123");
		    cardParams.put("name", "J Bindings Cardholder");
		    cardParams.put("address_line1", "140 2nd Street");
		    cardParams.put("address_line2", "4th Floor");
		    cardParams.put("address_city", "San Francisco");
		    cardParams.put("address_zip", "94105");
		    cardParams.put("address_state", "CA");
		    cardParams.put("address_country", "USA");
		    
		    final Map<String, Object> chargeParams = new HashMap<String, Object>();
		    chargeParams.put("amount", 100);
		    chargeParams.put("currency", "usd");
		    chargeParams.put("card", cardParams);
		    try
		    {
		    	 final Charge charge = Charge.create(chargeParams);
				    System.out.println(charge);
		    }
		    catch (Exception e) {
		    	 System.out.println(e);
			}
		   return _StripeTest;
	}
	
}
