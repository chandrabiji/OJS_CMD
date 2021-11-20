package com.hexaware.MLP321.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP321.model.Menu;
import com.hexaware.MLP321.factory.MenuFactory;
import javax.ws.rs.Consumes;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }
  /**
   * Returns Menu details of ID.
   * @param foodId food ID.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{foodId}")
  public final Menu findById(@PathParam("foodId") final int foodId) {
    Menu menu = MenuFactory.showItem(foodId);
    return menu;
  }
/**
 * @param foodId id
 * @param foodName name
 * @param foodQty qty
 * @param foodPrice price
 * @param vendorId vid
 * @return msg
 */
  @POST
  @Path("/create/{foodId}/{foodName}/{foodQuantity}/{foodPrice}/{vendorId}")
  public final String createMenuItem(@PathParam("foodId")final int foodId, @PathParam("foodName")final String foodName,
      @PathParam("foodQuantity")final int foodQty, @PathParam("foodPrice")final double foodPrice, @PathParam("vendorId")final int vendorId) {
        String msg = null;
    int result = MenuFactory.createItem(foodId, foodName, foodQty, foodPrice, vendorId);
    msg="Your Item "+result + "successfully inserted.";
    return msg;
  }
  /**
   * Deletes foodId.
   * @param foodId ID
   * @return result
   */
  /*@DELETE
  @Path("/delete/{foodId}")
  public final String deleteFoodItemById(@PathParam("foodId") final int foodId) {
    String msg = null;
    int result = MenuFactory.deleteItem(foodId);
    msg = "Your Item " + result +" successfully deleted.";
    return msg;
  }*/
  @DELETE
  @Path("/delete/{foodId}")
  public final int deleteFoodItemById(@PathParam("foodId") final int foodId) {
    int result = MenuFactory.deleteItem(foodId);
    return result;
  }
/**
 * Updates menu.
 * 
 */

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public String updateMenuItem(Menu menu) {
     String str = null;
     int n = MenuFactory.updateMenuItem(menu);
     str = "Your Item "+n+" Successfully Updated. ";
     return str;
   }

   /***
    * Updates quantity.
    */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateqty/{foodId}/{foodQuantity}")
    public String updateqty(@PathParam("foodId")final int foodId,@PathParam("foodQuantity")final int foodQty){
      String sr = null;
      int rs = MenuFactory.updateQuantity(foodId,foodQty);
      sr="Your Item"+rs+"Successfully Updated.";
      return sr;
    }

}
