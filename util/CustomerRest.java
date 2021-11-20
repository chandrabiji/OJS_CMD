package com.hexaware.MLP321.util;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP321.model.Customer;
import com.hexaware.MLP321.factory.CustomerFactory;
import javax.ws.rs.Consumes;

/**
 * This class provides a REST interface for the customer entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Customer[] listCustomer() {
    final Customer[] customer = CustomerFactory.showAllCustomers();
    return customer;
  }

   /**
   * Returns customer details of ID.
   * @param customerId customer ID.
   * @return the customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{customerId}")
  public final Customer findByCId(@PathParam("customerId") final int customerId) {
    Customer customer = CustomerFactory.showCustomer(customerId);
    return customer;
  }
/**
 * 
 * @param customer
 * @return str
 */
  @PUT
  @Path("/update")
  @Consumes(MediaType.APPLICATION_JSON)
  public final String updateCustomer(final Customer customer) {
    String str = null;
    int result = CustomerFactory.updateCustomer(customer);
    if (result != 0) {
      str = "Successfully Customer Object Updated ";
    } else {
      str = "Customer Object Notable to updated.Please try again..";
    }
    return str;
  }
  /**
   * Create Customer.
   * @param customerId cus id
   * @param customerName cus name
   * @param customerEmail cus email
   * @param customerMobileNo cus num
   * @param customerPassword cus pass
   * @param customerAddress cus add
   * @param walletName wallet name
   * @param walletAmount wallet amt
   * @return msg
   */
  @POST
  @Path("/create/{customerId}/{customerName}/{customerEmail}/{customerMobileNo}/{customerPassword}/{customerAddress}/{walletName}/{walletAmount}")
  public final String createCustomer(@PathParam("customerId") final int customerId, @PathParam("customerName") final String customerName,
        @PathParam("customerEmail") final String customerEmail, @PathParam("customerMobileNo") final String customerMobileNo,
        @PathParam("customerPassword") final String customerPassword, @PathParam("customerAddress") final String customerAddress,
        @PathParam("walletName") final String walletName, @PathParam("walletAmount") final double walletAmount) {
    String msg = null;
    int n = CustomerFactory.createCustomer(customerId, customerName, customerEmail, customerMobileNo,
        customerPassword, customerAddress, walletName, walletAmount);
    if (n != 0) {
      msg = "Successfully Customer Record Inserted.";
    } else {
      msg = "Not able to Created Customer Record.Please try again";
    }
    return msg;
  }

  /**
   * Fetch cus details.
   * @param customerEmail email
   * @param customerPassword pass
   * @return cus
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/fetch/{customerEmail}/{customerPassword}")
  public final Customer fetchCustomerDetails(@PathParam("customerEmail") final String customerEmail,
      @PathParam("customerPassword") final String customerPassword) {
    Customer customer = CustomerFactory.fetch(customerEmail, customerPassword);
    return customer;
  }
  /**
   * Delete customer.
   * @param customerId cus ID
   * @return res
   */
  @DELETE
  @Path("/delete/{customerId}")
  public final String deleteCustomer(@PathParam("customerId") final int customerId) {
    String res = null;
    int n = CustomerFactory.deleteCustomer(customerId);
    if (n != 0) {
      res = "Successfully Customer Deleted.";
    } else {
      res = "Cannot Delete the customer.";
    }
    return res;
  }

  /**
   * Update Wallet.
   * @param customerId cus id
   * @param walletAmount amt
   *
   */
  @PUT
  @Path("/updateWallet/{customerId}/{walletAmount}")
  public final void updateCustomerWallet(@PathParam("customerId") final int customerId, @PathParam("walletAmount") final double walletAmount) {
    CustomerFactory.updateWallet(customerId, walletAmount);
    System.out.println("Customer Wallet Updated Successfully.");
  }

}
