package com.zenofprogramming.cookiegram.dispatchers;
import com.zenofprogramming.cookiegram.domainobjects.CookieOrder;
import com.zenofprogramming.cookiegram.dto.PaymentResponse;
import com.zenofprogramming.cookiegram.usecasemanagers.PaymentManager;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class PaymentDispatcherStub implements PaymentManager
{

   @Override
   public PaymentResponse makePayment (CookieOrder cookieOrder)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
