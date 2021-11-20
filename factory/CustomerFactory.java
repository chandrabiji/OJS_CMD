package com.hexaware.MLP321.factory;

import com.hexaware.MLP321.persistence.CustomerDAO;
import com.hexaware.MLP321.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP321.model.Customer;

/**
 * CustomerFactory class used to fetch customer data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   * Constrcutor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   */
  public static Customer[] showAllCustomers() {
    List<Customer> customer = dao().showCustomers();
    return customer.toArray(new Customer[customer.size()]);
  }
  /**
   * @param customerId to initialize customerId.
   * @return the customer object.
   */
  public static Customer showCustomer(final int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.findByCId(customerId);
    return customer;
  }
  /**
   * Update the customer details.
   * @param customer to initialize Customer object.
   * @return result.
   */
  public static int updateCustomer(final Customer customer) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result = dao.update(customer);
    return result;
  }
  /**
   * Insert new customer.
   * @param customerId to initialize customerId.
   * @param customerName to initialize customerName.
   * @param customerEmail to initialize customerEmail.
   * @param customerAddress to initialize customerAddresss.
   * @param customerMobileNo to initialize customerMobileNO.
   * @param customerPassword to initialize customerPassword.
   * @param walletName to initialize walletName.
   * @param walletAmount to initialize walletAmount.
   * @return addCusres.
   */
  public static int createCustomer(final int customerId, final String customerName, final String customerEmail,
      final String customerAddress, final String customerMobileNo, final String customerPassword,
      final String walletName, final double walletAmount) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int res = dao.createCustomerId(customerId, customerName, customerEmail, customerAddress, customerMobileNo,
        customerPassword, walletName, walletAmount);
    return res;
  }
  /**
   * Update the customer walletAmount.
   * @param customerId to initialize customerId.
   * @param walletAmount to initialize walletAmount.
   */
  public static void updateWallet(final int customerId, final double walletAmount) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    dao.updateWA(customerId, walletAmount);
  }
  /**
   * @param customerEmail to initialize customerEmail.
   * @param customerPassword to initialize customerPassword.
   * @return customer list object.
   */
  public static Customer fetch(final String customerEmail, final String customerPassword) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.display(customerEmail, customerPassword);
    return customer;
  }
  /**
   * Delete the customer.
   * @param customerId to initialize the customerId.
   * @return result.
   */
  public static int deleteCustomer(final int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result = dao.deleteById(customerId);
    return result;
  }
  /**
   * @param customerEmail to initialize customer email.
   * @param customerPassword to initialize customer password.
   * @return customer object.
   */
  public static Customer checkCustomer(final String customerEmail, final String customerPassword) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.displays(customerEmail, customerPassword);
    return customer;
  }

}
