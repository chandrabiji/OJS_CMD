package com.hexaware.MLP321.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
// import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
// import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP321.model.Vendor;
import com.hexaware.MLP321.factory.VendorFactory;

/**
 * This class provides a REST interface for the Vendor entity.
 */

@Path("/vendor")
public class VendorRest {
  /**
   * List all Vendor details.
   * @return vendor details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }
  /**
   * Fetch cred details.
   * @param vendorEmailId email
   * @param vendorPassword pass
   * @return vendor
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/fetch/{vendorEmail}/{vendorPassword}")
  public final Vendor fetchVendor(@PathParam("vendorEmail") final String vendorEmailId,
      @PathParam("vendorPassword") final String vendorPassword) {
    Vendor vendor = VendorFactory.fetch(vendorEmailId, vendorPassword);
    return vendor;
  }
  /**
   * Getting vendor details by ID.
   * @param vendorId vendor id
   * @return vendor
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{vendorId}")
  public final Vendor getVendorById(@PathParam("vendorId") final int vendorId) {
    Vendor vendor = VendorFactory.findVendorById(vendorId);
    return vendor;
  }
  /**
   * Create vendor.
   * @param vendorId id
   * @param vendorName name
   * @param vendorEmail email
   * @param vendorPhoneNo phone
   * @param vendorAddress address
   * @param vendorPassword pass
   * @return res
   */
  @POST
  @Path("/create/{vendorId}/{vendorName}/{vendorEmail}/{vendorPhoneNo}/{vendorAddress}/{vendorPassword}")
  public static String createVendor(@PathParam("vendorId") final int vendorId, @PathParam("vendorName") final String vendorName,
      @PathParam("vendorEmail") final String vendorEmail, @PathParam("vendorPhoneNo") final String vendorPhoneNo,
      @PathParam("vendorAddress") final String vendorAddress, @PathParam("vendorPassword") final String vendorPassword) {
    int res = VendorFactory.createVendor(vendorId, vendorName, vendorEmail, vendorPhoneNo, vendorAddress, vendorPassword);
    if (res != 0) {
      return "Vendor created";
    }
    return "Cannot create vendor.";
  }
  /**
   * Delete vendor.
   * @param vendorId id
   * @return res
   */
  @DELETE
  @Path("delete/{vendorId}")
  public static String deteteVendor(@PathParam("vendorId") final int vendorId) {
    int res = VendorFactory.deleteVendor(vendorId);
    if (res != 0) {
      return "Vendor Deleted.";
    }
    return "Cannot Delete vendor of ID : " + vendorId;
  }
}
