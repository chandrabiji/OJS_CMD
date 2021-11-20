package com.hexaware.MLP321.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;
import com.hexaware.MLP321.model.Menu;


/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
    /**
     * @param foodId gets the foodId.
     * @return the Menu record with this foodId.
     */
  @SqlQuery("Select * from mlp321.menu where FOOD_ID = :id")
    @Mapper(MenuMapper.class)
    Menu findById(@Bind("id")int foodId);
    /**
     * @param foodId to initialize foodId.
     * @param foodName to initialize foodName.
     * @param foodQty to initialize foodQty.
     * @param foodPrice to initialize foodPrice.
     * @param vendorId to initialize vendor id.
     * @return a new record.
     */
  @SqlUpdate("insert into mlp321.menu(FOOD_ID, FOOD_NAME, FOOD_QTY, FOOD_PRICE, VENDOR_ID) values(:id, :name, :qty, :price, :vid)")
    @Mapper(MenuMapper.class)
    int createMenuItem(@Bind("id")int foodId, @Bind("name")String foodName, @Bind("qty")int foodQty,
      @Bind("price")double foodPrice, @Bind("vid")int vendorId);
     /* @SqlUpdate("insert into mlp321.menu(FOOD_ID, FOOD_NAME, FOOD_QTY, FOOD_PRICE, VENDOR_ID) values(:menu.foodId, :menu.foodName,"+
      " :menu.foodQty, :menu.foodPrice, :menu.vendorId)")
      @Mapper(MenuMapper.class)
      int createMenuItem(@BindBean("menu")Menu menu);*/
    /**
     * Update the food item.
     * @param menu to initialize the Menu object.
     * @return updated menu item.
     */
  @SqlUpdate("update mlp321.menu set FOOD_NAME = :menu.foodName, FOOD_QTY= :menu.foodQty, FOOD_PRICE= :menu.foodPrice,"
      + " vendor_id= :menu.vendorId where FOOD_ID = :menu.foodId")
    int update(@BindBean("menu")Menu menu);
    /**
     * Delete the food item.
     * @param foodId to initialize the foodId.
     * @return result.
     */
  @SqlUpdate("delete from mlp321.menu  where FOOD_ID = :fid")
    @Mapper(MenuMapper.class)
    int deleteById(@Bind("fid")int foodId);
    /**
     * Update the food Quantity.
     * @param foodId to initialize foodId.
     * @param foodQty to initialize foodQty.
     * @return res.
     */
  @SqlUpdate("update mlp321.menu set FOOD_QTY= :foodQty where FOOD_ID= :foodId")
    @Mapper(MenuMapper.class)
    int updateQty(@Bind("foodId")int foodId, @Bind("foodQty")int foodQty);

}
