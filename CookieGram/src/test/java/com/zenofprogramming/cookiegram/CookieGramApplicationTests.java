package com.zenofprogramming.cookiegram;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.zenofprogramming.cookiegram.dto.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class CookieGramApplicationTests {
@Autowired
private MockMvc mockMvc;
	

@Test
	void testLoadLandingPage() throws Exception {
	this.mockMvc.perform(get("/")) 
	.andExpect(status().isOk())
	.andExpect(view().name("landingpage.html"));		
	}


@Test
public void testValidOrderRequestResultsInNewCookieOrder ()
{
	LocalDate dateOfOrder =  LocalDate.now().plusDays(5);
	OrderRequest orderRequest = OrderRequest.builder()
			.cookieMessage("Happy Birthday")
			.customerEmail("jerry@fmb.com")
			.customerName("Jerry Kotuba")
			.deliveryDate(dateOfOrder)
			.recipientCity("Vancouver")
			.recipientCountry("Canada")
			.recipientCode("L4D3R7")
			.recipientName("Liz Dancy")
			.recipientStreetAddress("123 Jazzy St").build();
		
			OrderRequestResponse response = CookieGram.instanceOfOrderManager().createOrder(orderRequest);
			assertEquals (response.isSuccess(),true);
			assertTrue (response.getReturnMessageToUser().contains("Thank you for your order!"));
}

@Test
public void testOrderRequestWithInvalidCountyResultsInNewCookieOrder ()
{
	LocalDate dateOfOrder =  LocalDate.now().plusDays(5);
	OrderRequest orderRequest = OrderRequest.builder()
			.cookieMessage("Happy Birthday")
			.customerEmail("jerry@fmb.com")
			.customerName("Jerry Kotuba")
			.deliveryDate(dateOfOrder)
			.recipientCity("Vancouver")
			.recipientCountry("US")
			.recipientCode("L4D3R7")
			.recipientName("Liz Dancy")
			.recipientStreetAddress("123 Jazzy St").build();
		
			OrderRequestResponse response = CookieGram.instanceOfOrderManager().createOrder(orderRequest);
			assertEquals (response.isSuccess(),false);
			assertTrue (response.getReturnMessageToUser().contains("Sorry, we can't ship to that address"));
}

}
