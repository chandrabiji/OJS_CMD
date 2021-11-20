package com.hexaware.MLP321.factory;

import com.hexaware.MLP321.persistence.MenuDAO;
import com.hexaware.MLP321.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP321.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
  /**
   * @param foodId to initialize foodId.
   * @return the menu object.
   */
  public static Menu showItem(final int foodId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    Menu menu = dao.findById(foodId);
    return menu;
  }
  /**
   * Delete the food item.
   * @param foodId to initialize the foodId.
   * @return result.
   */
  public static int deleteItem(final int foodId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result = dao.deleteById(foodId);
    return result;
  }
  /**
   * insert the food item.
   * @param foodId to initialize foodId.
   * @param foodName to initialize foodName.
   * @param foodQty to initialize foodQty.
   * @param foodPrice to initialize foodPrice.
   * @param vendorId to initialize vendorId.
   * @return result.
   */
  public static int createItem(final int foodId, final String foodName, final int foodQty, final double foodPrice, final int vendorId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result = dao.createMenuItem(foodId, foodName, foodQty, foodPrice, vendorId);
    return result;
  }
 /* public static int createItem(final Menu menu){
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result= dao.createMenuItem(menu);
    return result;
  }*/
  /**
   * Update the food item.
   * @param menu to initialize the Menu object.
   * @return result.
   */
  public static int updateMenuItem(final Menu menu) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result = dao.update(menu);
    return result;
  }
  /**
   * Update the food Quantity.
   * @param foodId to initialize foodId.
   * @param foodQty to initialize foodQty.
   * @return res.
   */
  public static int updateQuantity(final int foodId, final int foodQty) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result = dao.updateQty(foodId, foodQty);
    return result;
  }
}

