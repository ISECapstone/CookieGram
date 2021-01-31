package com.zenofprogramming.cookiegram;

import com.zenofprogramming.cookiegram.dispatchers.OrderPersistanceDispatcherStub;
import com.zenofprogramming.cookiegram.dispatchers.PaymentDispatcherStub;
import com.zenofprogramming.cookiegram.dispatchers.SettingsPersistanceDispatcherStub;
import com.zenofprogramming.cookiegram.dispatchers.ShippingDispatcherStub;
import com.zenofprogramming.cookiegram.usecasemanagers.OrderManager;
import com.zenofprogramming.cookiegram.usecasemanagers.OrderPersistanceManager;
import com.zenofprogramming.cookiegram.usecasemanagers.PaymentManager;
import com.zenofprogramming.cookiegram.usecasemanagers.SettingsPersistanceManager;
import com.zenofprogramming.cookiegram.usecasemanagers.ShippingManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * TODO - add java docs
 * refactor baking views etc
 * clean up code
 * clean up templates
 * add template fragments
 *
 */

@SpringBootApplication
public class CookieGram
{
   static SettingsPersistanceManager settingsPersistanceManager;
   static OrderPersistanceManager orderPersistanceManager;
   static ShippingManager shippingManager;
   static PaymentManager paymentManager;
   static OrderManager orderManager;

   public static void main (String[] args)
   {
      SpringApplication.run(CookieGram.class, args);
   }

   public static PaymentManager instanceOfPaymentManager ()
   {
      System.out.println("injecting PaymentDispatcherStub");
      if (paymentManager == null) {
         paymentManager = new PaymentDispatcherStub();
      }
      return paymentManager;
   }

   public static OrderPersistanceManager instanceOfOrderPersistanceManager ()
   {
      System.out.println("OrderPersistanceDispatcherStub");
      if (orderPersistanceManager == null) {
         orderPersistanceManager = new OrderPersistanceDispatcherStub();
      }
      return orderPersistanceManager;

   }

   public static SettingsPersistanceManager instanceOfSettingsPersistanceManager ()
   {
      System.out.println("injecting SettingsPersistanceDispatcher");
      if (settingsPersistanceManager == null) {
         settingsPersistanceManager = new SettingsPersistanceDispatcherStub();
      }
      return settingsPersistanceManager;
   }

   public static ShippingManager instanceOfShippingManager ()
   {
      System.out.println("injecting ShippingDispatcherStub");
      if (shippingManager == null) {
         shippingManager = new ShippingDispatcherStub();
      }
      return shippingManager;
   }

   public static OrderManager instanceOfOrderManager ()
   {
      if (orderManager == null) {
         orderManager = new OrderManager();
      }
      return orderManager;
   }

}
