package com.hexaware.MLP321.util;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
//import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP321.model.Order;
import com.hexaware.MLP321.factory.OrderFactory;
import com.hexaware.MLP321.model.Bill;

/**
 * This class provides a REST interface for the order entity.
 */
@Path("/order")
public class OrderRest {
  /**
   * Returns Order details.
   * @return the order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Order[] listOrders() {
    Order[] orders = OrderFactory.showOrder();
    return orders;
  }
  /**
   * Create Order.
   * @param orderId order ID
   * @param foodId food ID
   * @param vendorId vendor ID
   * @param customerId customer ID
   * @param noOfItems No of Items
   * @param orderDateTime Order date and time
   * @param amountToBePaid amount to be paid
   * @param tokenNumber token number
   * @param status status
   * @param comment comment
   * @return result string
   */
  @POST
  @Path("/create/{orderId}/{foodId}/{vendorId}/{customerId}/{noOfItems}/{orderDateTime}/{amountToBePaid}/{tokenNumber}/{status}/{comment}")
  public final String createOrder(@PathParam("orderId") final int orderId, @PathParam("foodId") final int foodId,
      @PathParam("vendorId") final int vendorId, @PathParam("customerId") final int customerId,
      @PathParam("noOfItems") final int noOfItems, @PathParam("orderDateTime") final String orderDateTime,
      @PathParam("amountToBePaid") final double amountToBePaid, @PathParam("tokenNumber") final int tokenNumber,
      @PathParam("status") final String status, @PathParam("comment") final String comment) {
    int res = OrderFactory.createOrder(orderId, foodId, vendorId, customerId, noOfItems, orderDateTime, amountToBePaid,
        tokenNumber, status, comment);
    if (res != 0) {
      return "Successfully Created";
    }
    return "Cannot create!";
  }
  /**
   * Get the order details by customer ID.
   * @param customerId cus ID
   * @return Order list
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getbycus/{customerId}")
  public final Order[] listOrderByCust(@PathParam("customerId") final int customerId) {
    Order[] order = OrderFactory.showAllOrders(customerId);
    return order;
  }
  /**
   * Get order detail of order ID.
   * @param orderId order Id
   * @return order
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getbyord/{orderId}")
  public final Order listOrderByOrder(@PathParam("orderId") final int orderId) {
    Order order = OrderFactory.showOById(orderId);
    return order;
  }
  /**
   * Get order by vendor id.
   * @param vendorId vednor id
   * @return order array
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getbyvendor/{vendorId}")
  public final Order[] listOrderByVendor(@PathParam("vendorId") final int vendorId) {
    Order[] order = OrderFactory.showAllVOrders(vendorId);
    return order;
  }
  /**
   * Delete Order by order ID.
   * @param orderId order Id
   * @return res
   */
  @DELETE
  @Path("/delete/{orderId}")
  public final String deleteOrder(@PathParam("orderId") final int orderId) {
    int res = OrderFactory.deleteOrder(orderId);
    if (res != 0) {
      return orderId + "Deleted successfully";
    }
    return "Cannot delete " + orderId;
  }
  /**
   * Update order status.
   * @param orderId order id
   * @param status status
   * @return res
   */
  @PUT
  @Path("/update/{orderId}/{status}")
  public final String updateStatus(@PathParam("orderId") final int orderId, @PathParam("status") final String status) {
    int res = OrderFactory.updateStatus(orderId, status);
    if (res != 0) {
      return orderId + "Updated successfully";
    }
    return "Cannot Update " + orderId;
  }
/**
 * gets bill.
 * @param orderId order id
 * @return bill
 */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/bill/{orderId}")
  public final Bill[] getBill(@PathParam("orderId") final int orderId) {
    Bill[] bill = OrderFactory.showOrders(orderId);
    return bill;
  }
}
