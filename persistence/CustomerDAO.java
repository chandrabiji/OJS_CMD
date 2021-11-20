package com.hexaware.MLP321.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;

import com.hexaware.MLP321.model.Customer;

/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
     /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from customer")
    @Mapper(CustomerMapper.class)
    List<Customer> showCustomers();
    /**
     * @param customerId gets the customerId.
     * @return the Customer record with this customerId.
     */
  @SqlQuery("Select * from mlp321.customer where customer_id= :id")
    @Mapper(CustomerMapper.class)
    Customer findByCId(@Bind("id") int customerId);
    /**
     * Update the customer details.
     * @param customer to initialize Customer object.
     * @return the updated customer.
     */
  @SqlUpdate("update mlp321.customer set customer_name= :customer.customerName, customer_email= :customer.customerEmail,"
      + " customer_address= :customer.customerAddress, customer_mobile= :customer.customerMobileNo, customer_password= :customer.customerPassword,"
      + " wallet_name= :customer.walletName, wallet_amount= :customer.walletAmount where customer_id= :customer.customerId")
    int update(@BindBean("customer")Customer customer);
    /**
     * Insert new customer.
     * @param customerId to initialize customerId.
     * @param customerName to initialize customerName.
     * @param customerEmail to initialize customerEmail.
     * @param customerAddress to initialize customerAddresss.
     * @param customerMobileNo to initialize customerMobileNo.
     * @param customerPassword to initialize customerPassword.
     * @param walletName to initialize walletName.
     * @param walletAmount to initialize walletAmount.
     * @return addCusres.
     */
  @SqlUpdate("insert into mlp321.customer(customer_id, customer_name, customer_email, customer_address, customer_mobile,"
      + " customer_password, wallet_name, wallet_amount) values(:id, :name, :email, :address, :mobileno, :password, :wname, :wamount)")
    @Mapper(CustomerMapper.class)
    int createCustomerId(@Bind("id")int customerId, @Bind("name")String customerName,
      @Bind("email")String customerEmail, @Bind("address")String customerAddress, @Bind("mobileno")String customerMobileNo,
      @Bind("password") String customerPassword, @Bind("wname")String walletName, @Bind("wamount")double walletAmount);
    /**
     * Update the customer walletAmount.
     * @param customerId to initialize customerId.
     * @param walletAmount to initialize walletAmount.
     */
  @SqlUpdate("update  mlp321.customer set wallet_amount= :walletAmount where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    void updateWA(@Bind("customerId")int customerId, @Bind("walletAmount") double walletAmount);
    /**
     * @param customerEmail to initialize customerEmail.
     * @param customerPassword to initialize customerPassword.
     * @return customer list object.
     */
  @SqlQuery("Select * from mlp321.customer where customer_email= :customerEmail  AND customer_password = :customerPassword")
    @Mapper(CustomerMapper.class)
    Customer display(@Bind("customerEmail") String customerEmail, @Bind("customerPassword") String customerPassword);
    /**
     * Delete the customer.
     * @param customerId to initialize the customerId.
     * @return result.
     */
  @SqlUpdate("delete from mlp321.customer  where customer_id = :cid")
    @Mapper(CustomerMapper.class)
    int deleteById(@Bind("cid")int customerId);
    /**
     * @param customerEmail to initialize customer email.
     * @param customerPassword to initialize customer password.
     * @return customer object.
     */
  @SqlQuery("Select * from mlp321.customer where customer_email= :customerEmail  AND customer_password = :customerPassword")
    @Mapper(CustomerMapper.class)
    Customer displays(@Bind("customerEmail") String customerEmail, @Bind("customerPassword") String customerPassword);
}