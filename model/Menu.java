package com.hexaware.MLP321.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 **/
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  /**
 * foodName to store foodName.
 */
  private String foodName;
  /**
   * foodQtyto store foodQty.
   */
  private int foodQty;

  /**
   * foodPrice store foodPrice.
   */
  private double foodPrice;

  /**
   * vendor id store vendorId.
   */
  private int vendorId;
    /**
     * Default Constructor.
     */
  public Menu() {
  }
/**
 * @param argFoodId to initialize food id.
 * @param argFoodName to initialize food id.
 * @param argFoodQty to initialize food id.
 * @param argFoodPrice to initialize food id.
 * @param argVendorId to initialize food id.
 *
 * used to get details through constructor.
 */
  public Menu(final int argFoodId, final String argFoodName, final int argFoodQty, final double argFoodPrice, final int argVendorId) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.foodQty = argFoodQty;
    this.foodPrice = argFoodPrice;
    this.vendorId = argVendorId;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
     /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
      /**
     * @param argFoodName gets the food Name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
       /**
     * @return this food Qty.
     */
  public final int getFoodQty() {
    return foodQty;
  }
     /**
     * @param argFoodQty gets the food id.
     */
  public final void setFoodQty(final int argFoodQty) {
    this.foodQty = argFoodQty;
  }

        /**
     * @return this food Price.
     */
  public final double getFoodPrice() {
    return foodPrice;
  }
     /**
     * @param argFoodPrice gets the food price.
     */
  public final void setFoodPrice(final double argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }

       /**
     * @return this vendor ID.
     */
  public final int getVendorId() {
    return vendorId;
  }

    /**
     * @param argVendorId gets the food id.
     */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
}

