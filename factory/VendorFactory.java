package com.hexaware.MLP321.factory;
import com.hexaware.MLP321.persistence.VendorDAO;
import com.hexaware.MLP321.persistence.DbConnection;
import java.util.List;
import com.hexaware.MLP321.model.Vendor;
/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * @param vendorEmail to initialize vendorEmail.
   * @param vendorPassword to initialize vendorPassword.
   * @return vendor list object.
   */
  public static Vendor fetch(final String vendorEmail, final String vendorPassword) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    Vendor vendor = dao.display(vendorEmail, vendorPassword);
    return vendor;
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * Find vendor by ID.
   * @param vendorId ID
   * @return vendor
   */
  public static Vendor findVendorById(final int vendorId) {
    Vendor vendor = dao().findByVId(vendorId);
    return vendor;
  }
  /**
   * Create new vendor.
   * @param vendorId id
   * @param vendorName name
   * @param vendorEmail email
   * @param vendorPhoneNo phone
   * @param vendorAddress address
   * @param vendorPassword password
   * @return res
   */
  public static int createVendor(final int vendorId, final String vendorName, final String vendorEmail,
      final String vendorPhoneNo, final String vendorAddress, final String vendorPassword) {
    int res = dao().createVendor(vendorId, vendorName, vendorEmail, vendorPhoneNo, vendorAddress, vendorPassword);
    return res;
  }
  /**
   * Delete vendor.
   * @param vendorId id
   * @return res
   */
  public static int deleteVendor(final int vendorId) {
    int res = dao().deleteById(vendorId);
    return res;
  }
}
