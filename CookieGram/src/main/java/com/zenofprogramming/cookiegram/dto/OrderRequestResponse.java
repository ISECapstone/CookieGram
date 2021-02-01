package com.zenofprogramming.cookiegram.dto;
import com.zenofprogramming.cookiegram.domainobjects.CookieOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */

@Data
@AllArgsConstructor
public class OrderRequestResponse
{
//   private RequestResponseType responseType;
	   private boolean success = true;
	   private CookieOrder cookieOrder;
	   private String returnMessageToUser;
	   private String htmlPage;

}
