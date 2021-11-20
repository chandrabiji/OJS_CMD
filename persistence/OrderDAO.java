package com.hexaware.MLP321.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;
import com.hexaware.MLP321.model.Bill;
import com.hexaware.MLP321.model.Order;
/**
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
    /**
     * @return the all the Order record.
     */
  @SqlQuery("Select * from mlp321.order")
    @Mapper(OrderMapper.class)
    List<Order> show();
    /**
     * Insert order.
     * @param orderId to initialize order id.
     * @param foodId to initialize food id.
     * @param vendorId to initialize vendor id.
     * @param customerId to initialize customer id.
     * @param noOfItems to initialize no of items.
     * @param orderDateTime to initialize order datetime.
     * @param amountToBePaid to initialize amount to be paid.
     * @param tokenNumber to initialize token number.
     * @param status to initialize status.
     * @param comment to initialize comment.
     * @return new record.
     */
  @SqlUpdate("insert into mlp321.order(order_id, food_id, customer_id, vendor_id, no_of_items, order_date_time, amount_to_be_paid, "
      + "token_number, status, comments) values(:orid, :ofid, :ocid, :ovid, :onfi, :odt, :oamt, :otoken, :ostatus, :ocomment)")
    @Mapper(OrderMapper.class)
    int createOrderItem(@Bind("orid")int orderId, @Bind("ofid")int foodId, @Bind("ovid")int vendorId,
      @Bind("ocid")int customerId, @Bind("onfi")int noOfItems, @Bind("odt") String orderDateTime,
      @Bind("oamt")double amountToBePaid, @Bind("otoken")int tokenNumber, @Bind("ostatus")String status,
      @Bind("ocomment")String comment);
    /**
     * @param customerId gets the customerId.
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from mlp321.order where customer_id=:id")
    @Mapper(OrderMapper.class)
    List<Order> showById(@Bind("id")int customerId);
    /**
     * @param vendorId gets the customerId.
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from mlp321.order where vendor_id=:id")
    @Mapper(OrderMapper.class)
    List<Order> showByVId(@Bind("id")int vendorId);
    /**
     * @param orderId gets the customerId.
     * @return the Order record with this orderId.
     */
  @SqlQuery("Select * from mlp321.order where order_id=:id")
    @Mapper(OrderMapper.class)
    Order showByOId(@Bind("id")int orderId);
    /**
     * @param ordId to initialize orderID.
     * @return the all Order record.
     */
  @SqlQuery("Select * from (Select c.customer_id, c.wallet_name, c.wallet_amount, m.FOOD_ID, m.FOOD_NAME, m.FOOD_QTY, m.FOOD_PRICE, o.order_id "
      + " from mlp321.order o, mlp321.customer c, mlp321.menu m Where o.customer_id = c.customer_id  AND o.food_id = m.FOOD_ID) as a "
      + "where a.order_id= : ordId")
     @Mapper(BillMapper.class)
     List<Bill> showCart(@Bind("ordId") int ordId);
  /**
   * Update the customer walletAmount.
   * @param orderId to initialize orderID.
   * @return res.
   */
  @SqlUpdate("delete from mlp321.order where order_id = :orderId")
  @Mapper(OrderMapper.class)
  int deleteOrder(@Bind("orderId")int orderId);
   /**
     * Update the customer walletAmount.
     * @param orderId to initialize customerId.
     * @param status to initialize walletAmount.
     * @return res.
     */
  @SqlUpdate("update  mlp321.order set status= :status where order_id= :orderId")
    @Mapper(OrderMapper.class)
    int updateOrderStatus(@Bind("orderId")int orderId, @Bind("status") String status);
  /**
   * @param orderId order ID
   * @return order insterted status
   */
  @SqlUpdate("insert into mlp321.order(amount_to_paid,token_number,status,comment) values(:oamt, :otn, :ostatus, :ocomment) where order_id=:id")
    @Mapper(OrderMapper.class)
    int orderStatus(@Bind() int orderId);
}