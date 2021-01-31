/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenofprogramming.cookiegram.usecasemanagers;
import com.zenofprogramming.cookiegram.dto.OrderRequest;
/**
 *
 * @author smirich
 */
public interface ShippingManager
{
   double getShippingCosts (OrderRequest orderRequest);

   boolean verifyValidShippingAddress (OrderRequest orderRequest);
}
