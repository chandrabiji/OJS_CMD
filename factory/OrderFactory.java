package com.hexaware.MLP321.factory;

import com.hexaware.MLP321.persistence.OrderDAO;
import com.hexaware.MLP321.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP321.model.Order;
import com.hexaware.MLP321.model.Bill;
/**
 * OrderFactory class used to fetch order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  protected OrderFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of order object.
   */
  public static Order[] showOrder() {
    List<Order> order = dao().show();
    return order.toArray(new Order[order.size()]);
  }
  /**
   * Insert order.
   * @param orderId to initialize order id.
   * @param foodId to initialize food id.
   * @param vendorId to initialize vendor id.
   * @param customerId to initialize customer id.
   * @param noOfItems to initialize no of items.
   * @param orderDateTime to initialize order date time.
   * @param amountToBePaid to initialize amount to be paid.
   * @param tokenNumber to initialize token number.
   * @param status to initialize status.
   * @param comment to initialize comment.
   * @return orderresult.
   */
  public static int createOrder(final int orderId, final int foodId, final int vendorId, final int customerId,
      final int noOfItems, final String orderDateTime, final double amountToBePaid, final int tokenNumber,
      final String status, final String comment) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int orderresult = dao.createOrderItem(orderId, foodId, vendorId, customerId, noOfItems,
        orderDateTime, amountToBePaid, tokenNumber, status, comment);
    return orderresult;
  }
  /**
   * @param customerId to initialize customerId.
   * @return the array of order object.
   */
  public static Order[] showAllOrders(final int customerId) {
    List<Order> order = dao().showById(customerId);
    return order.toArray(new Order[order.size()]);
  }
  /**
   * @param orderId to initialize customerId.
   * @return the array of order object.
   */
  public static Order showOById(final int orderId) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    Order order = dao.showByOId(orderId);
    return order;
  }
  /**
   * @param orderId to initialize customerId.
   * @return the array of order object.
   */
  public static int deleteOrder(final int orderId) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int order = dao.deleteOrder(orderId);
    return order;
  }
  /**
   * @return the array of order object.
   */
  public static Order[] showStatuses() {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Order> orders = dao.show();
    return orders.toArray(new Order[orders.size()]);
  }
  /**
   * @param vendorId to initialize customerId.
   * @return the array of order object.
   */
  public static Order[] showAllVOrders(final int vendorId) {
    List<Order> order = dao().showByVId(vendorId);
    return order.toArray(new Order[order.size()]);
  }
  /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   * @return res.
   */
  public static int updateStatus(final int orderId, final String status) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int result = dao.updateOrderStatus(orderId, status);
    return result;
  }
  /**
   * Call the data base connection.
   * @param orderId order id.
   * @return the array of order object.
   */
  public static Bill[] showOrders(final int orderId) {
    List<Bill> bills =  dao().showCart(orderId);
    return bills.toArray(new Bill[bills.size()]);
  }
}