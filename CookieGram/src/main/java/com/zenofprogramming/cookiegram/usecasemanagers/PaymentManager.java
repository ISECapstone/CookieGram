package com.zenofprogramming.cookiegram.usecasemanagers;
import com.zenofprogramming.cookiegram.domainobjects.CookieOrder;
import com.zenofprogramming.cookiegram.dto.PaymentResponse;
/**
 *
 * @author smirich
 */
public interface PaymentManager
{
   PaymentResponse makePayment (CookieOrder cookieOrder);
}
