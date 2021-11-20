package com.hexaware.MLP321.util;
import java.util.Scanner;
import java.sql.Timestamp;
// import java.util.List;
import java.util.Random;
import com.hexaware.MLP321.factory.OrderFactory;
import com.hexaware.MLP321.model.Order;
import com.hexaware.MLP321.factory.MenuFactory;
import com.hexaware.MLP321.model.Menu;
import com.hexaware.MLP321.model.Customer;
import com.hexaware.MLP321.factory.CustomerFactory;
import com.hexaware.MLP321.model.Vendor;
import com.hexaware.MLP321.factory.VendorFactory;
import com.hexaware.MLP321.model.Bill;

/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  private int loginCustomerID = 0;
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|      Canteen Management System       |");
    System.out.println("|--------------------------------------|");
    System.out.println("|           1. Vendor                  |");
    System.out.println("|           2. Customer                |");
    System.out.println("|           3. Exit                    |");
    System.out.println("|--------------------------------------|");
    mainMenuDetails();
  }
  /**
   * mainMenuDetails method  process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Select the Choice (1-3) :");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          vendorCredDetails();
          break;
        case 2:
          customerCredDetails();
          break;
        case 3:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          mainMenu();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    mainMenu();
  }
  /**
   * vendorDetails method to check the credentials.
   */
  private void vendorCredDetails() {
    System.out.println("|--------------------------------------|");
    System.out.println("|             Vendor Login             |");
    System.out.println("|--------------------------------------|");
    System.out.println("Enter the Email id : ");
    String vendorEmail = option.next();
    System.out.println("Enter the Password : ");
    String vendorPassword = option.next();
    Vendor vendor = VendorFactory.fetch(vendorEmail, vendorPassword);
    //loginVendorID = vendor.getVendorId();
    if (!(vendor.getVendorEmail() == null)) {
      System.out.println("-----LOGGING IN-----");

      vendorMainMenu();
    } else {
      System.out.println("-----INVALID USERNAME OR PASSWORD-----");
    }
  }
  /**
   * vendormainMenu method  used to display the option we had in the application.
   */
  private void vendorMainMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|           Vendor Main Menu           |");
    System.out.println("|--------------------------------------|");
    System.out.println("|         1. Food Menu                 |");
    System.out.println("|         2. Orders                    |");
    System.out.println("|         3. Customers                 |");
    System.out.println("|         4. Back                      |");
    System.out.println("|--------------------------------------|");
    vendorMainMenuDetails();
  }
  /**
   * vendormainMenuDetails method  process the option selected from vendor main menu.
   */
  private void vendorMainMenuDetails() {
    try {
      System.out.println("Select the Choice (1-4) :");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          foodItemsMenu();
          break;
        case 2:
          ordersMainMenu();
          break;
        case 3:
          vendorCustomerMenu();
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          mainMenu();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    vendorMainMenu();
  }
  /**
   * FoodItemMenu method  used to display the option we had in the application.
   */
  private void foodItemsMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|             Food Main Menu           |");
    System.out.println("|--------------------------------------|");
    System.out.println("|       1. Add Items                   |");
    System.out.println("|       2. View Item                   |");
    System.out.println("|       3. View All Items              |");
    System.out.println("|       4. Update Items                |");
    System.out.println("|       5. Delete Items                |");
    System.out.println("|       6. Back                        |");
    System.out.println("|--------------------------------------|");
    foodItemsMenuDetails();
  }
  /**
   * foodItemsMenuDetails method  process the option selected from vendor main menu.
   */
  private void foodItemsMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Food ID : ");
          int id = option.nextInt();
          System.out.println("Enter Food Name : ");
          String name = option.next();
          System.out.println("Enter Food Quantity : ");
          int qty = option.nextInt();
          System.out.println("Enter Food Price : ");
          double price = option.nextDouble();
          System.out.println("Enter Vendor ID : ");
          int vId = option.nextInt();
          createMenuItem(id, name, qty, price, vId);
          break;
        case 2:
          System.out.println("Enter Food ID : ");
          showItem(option.nextInt());
          break;
        case 3:
          showFullMenu();
          break;
        case 4:
          System.out.println("Enter Food ID : ");
          int fid = option.nextInt();
          System.out.println("Enter Food Name : ");
          String fname = option.next();
          System.out.println("Enter Food Quantity : ");
          int fqty = option.nextInt();
          System.out.println("Enter Food Price : ");
          double fprice = option.nextDouble();
          System.out.println("Enter Vendor ID : ");
          int fvid = option.nextInt();
          Menu menu = new Menu(fid, fname, fqty, fprice, fvid);
          updateMenuItem(menu);
          break;
        case 5:
          System.out.println("Enter Food ID : ");
          deleteMenuItem(option.nextInt());
          break;
        case 6:
          vendorMainMenu();
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          vendorMainMenu();
      }
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      System.out.println(e);
    }
    option.nextLine();
    foodItemsMenu();
  }
  /**
   * ordersMainMenu method  used to display the option we had in the application.
   */
  private void ordersMainMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|           Orders Main Menu           |");
    System.out.println("|--------------------------------------|");
    System.out.println("|       1. Accept/Decline Orders       |");
    System.out.println("|       2. Order Status                |");
    System.out.println("|       3. Back                        |");
    System.out.println("|--------------------------------------|");
    ordersMainMenuDetails();
  }
  /**
   * ordersMainMenuDetails method  process the option selected from vendor main menu.
   */
  private void ordersMainMenuDetails() {
    try {
      System.out.println("Select the Choice (1 or 2) :");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Order ID : ");
          int orderId = option.nextInt();
          showOrderById(orderId);
          System.out.println("|--------------------------------------|");
          System.out.println("|       1. Accept Order                |");
          System.out.println("|       2. Decline Order               |");
          System.out.println("|--------------------------------------|");
          System.out.println("Select the Choice (1 or 2) :");
          int orderAcc = option.nextInt();
          String status = "";
          if (orderAcc == 1) {
            status = "Order Accepted";
          } else {
            status = "Order Declined";
          }
          OrderFactory.updateStatus(orderId, status);
          showOrderById(orderId);
          ordersMainMenuDetails();
          break;
        case 2:
          showOrderStatuses();
          break;
        case 3:
          vendorMainMenu();
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          vendorMainMenu();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    ordersMainMenu();
  }
   /**
   * vendorCustomerMenu method  used to display the option we had in the application.
   */
  private void vendorCustomerMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|       Vendor Customer Main Menu      |");
    System.out.println("|--------------------------------------|");
    System.out.println("|      1. Add Customer                 |");
    System.out.println("|      2. View Customer                |");
    System.out.println("|      3. View All Customers           |");
    System.out.println("|      4. Update Customer              |");
    System.out.println("|      5. Delete Customer              |");
    System.out.println("|      6. Back                         |");
    System.out.println("|--------------------------------------|");
    vendorCustomerMenuDetails();
  }
  /**
   * vendorCustomerMenuDetails method  process the option selected from vendorCustomerMainMenu.
   */
  private void vendorCustomerMenuDetails() {
    try {
      System.out.println("Select the Choice (1-6) : ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Customer ID : ");
          int ncid = option.nextInt();
          System.out.println("Enter Customer Name : ");
          String ncname = option.next();
          System.out.println("Enter Customer Email : ");
          String ncemail = option.next();
          System.out.println("Enter Customer Address : ");
          String ncaddress = option.next();
          System.out.println("Enter Customer Mobile : ");
          String ncmobileno = option.next();
          System.out.println("Enter Customer Password :");
          String ncpassword = option.next();
          System.out.println("Enter Wallet Name : ");
          String ncwalletname = option.next();
          System.out.println("Enter Wallet Amount : ");
          double ncwalletamount = option.nextDouble();
          createCustomerId(ncid, ncname, ncemail, ncaddress, ncmobileno, ncpassword, ncwalletname, ncwalletamount);
          break;
        case 2:
          System.out.println("Enter the Customer ID to search for : ");
          showCustomer(option.nextInt());
          break;
        case 3:
          customersDetails();
          break;
        case 4:
          System.out.println("Enter Customer ID : ");
          int ucid = option.nextInt();
          System.out.println("Enter Customer Name : ");
          String ucname = option.next();
          System.out.println("Enter Customer Email : ");
          String ucemail = option.next();
          System.out.println("Enter Customer Address : ");
          String ucaddress = option.next();
          System.out.println("Enter Customer Mobile : ");
          String ucmobileno = option.next();
          System.out.println("Enter Customer Password :");
          String ucpassword = option.next();
          System.out.println("Enter Wallet Name : ");
          String ucwalletname = option.next();
          System.out.println("Enter Wallet Amount");
          double ucwalletamount = option.nextDouble();
          Customer ucus = new Customer(ucid, ucname, ucemail, ucaddress, ucmobileno, ucpassword, ucwalletname, ucwalletamount);
          updateCustomer(ucus);
          break;
        case 5:
          System.out.println("Enter Customer ID : ");
          deleteCustomer(option.nextInt());
          System.out.println("----CUSTOMER DETAILS DELETED SUCESSFULLY----");
          vendorCustomerMenu();
          break;
        case 6:
          mainMenu();
          break;
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          vendorCustomerMenu();
          break;
      }
    } catch (RuntimeException e) {
      throw e;

    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    vendorMainMenu();
  }

  /**
   * customerDetails method to check the credentials.
   */
  private void customerCredDetails() {
    System.out.println("|--------------------------------------|");
    System.out.println("|             Customer Login           |");
    System.out.println("|--------------------------------------|");
    System.out.println("Enter the Email id : ");
    String customerEmail = option.next();
    System.out.println("Enter the Password : ");
    String customerPassword = option.next();
    Customer customer1 = CustomerFactory.fetch(customerEmail, customerPassword);

    if (!(customer1.getCustomerId() == 0)) {
      System.out.println("-----LOGGING IN-----");
      loginCustomerID = customer1.getCustomerId();
      System.out.println(loginCustomerID);
      customerMainMenu();
    } else {
      System.out.println("-----INVALID USERNAME OR PASSWORD-----");
    }
  }
  // /**
  //  * customerMainMenu method  used to display the option we had in the application.
  //  */
  private void customerMainMenu() {
    System.out.println("|*  WELCOME TO CUSTOMER MAIN MENU *|");
    System.out.println("|--------------------------------------|");
    System.out.println("|          Customer Main Menu          |");
    System.out.println("|--------------------------------------|");
    System.out.println("|   1. Profile                         |");
    System.out.println("|   2. Vendor Profile                  |");
    System.out.println("|   3. Food Menu                       |");
    System.out.println("|   4. Orders                          |");
    System.out.println("|   5. Back                            |");
    System.out.println("|--------------------------------------|");
    customerMainMenuDetails();
  }
  // /**
  //  * customerMainMenuDetails method  process the option selected from customerMainMenu.
  //  */
  private void customerMainMenuDetails() {
    try {
      System.out.println("Select the Option (1-5) : ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          profileMenu();
          break;
        case 2:
          vendorProfile();
          break;
        case 3:
          menuItems();
          break;
        case 4:
          orderMenu();
          break;
        case 5:
          mainMenu();
          break;
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          customerMainMenu();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    customerMainMenu();
  }
   /**
   * profileMenu method  used to display the option we had in the application.
   */
  private void profileMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|         Customer Profile  Menu       |");
    System.out.println("|--------------------------------------|");
    System.out.println("|    1. View Profile                   |");
    System.out.println("|    2. Edit Profile                   |");
    System.out.println("|    3. Back                           |");
    System.out.println("|--------------------------------------|");
    profileMenuDetails();
  }
  /**
   * profileMenuDetails method  process the option selected from customerProfileMenu.
   */
  private void profileMenuDetails() {
    try {
      System.out.println("Select the Option (1-3) : ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showCustomer(loginCustomerID);
          break;
        case 2:
          System.out.println("Customer ID : " + loginCustomerID);
          int cid = loginCustomerID;
          System.out.println("Enter Customer Name : ");
          String cname = option.next();
          System.out.println("Enter Customer Email : ");
          String cemail = option.next();
          System.out.println("Enter Customer Address : ");
          String caddress = option.next();
          System.out.println("Enter Customer Mobile : ");
          String cmobileno = option.next();
          System.out.println("Enter Customer Password : ");
          String cpassword = option.next();
          System.out.println("Enter Wallet Name : ");
          String cwalletname = option.next();
          System.out.println("Enter Wallet Amount : ");
          double cwalletamount = option.nextDouble();
          Customer customer = new Customer(cid, cname, cemail, caddress, cmobileno, cpassword, cwalletname, cwalletamount);
          updateCustomer(customer);
          break;
        case 3:
          customerMainMenu();
          break;
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          profileMenu();
          break;
      }
    } catch (RuntimeException e) {
      System.out.println(e);
    } catch (Exception e) {
      System.out.println(e);
    }
    option.nextLine();
    profileMenu();
  }
  /**
   * vendorProfile method  used to display the option we had in the application.
   */
  private void vendorProfile() {
    System.out.println("|--------------------------------------|");
    System.out.println("|            Vendor Details            |");
    System.out.println("|--------------------------------------|");
    System.out.println("|   1. Vendor profile                  |");
    System.out.println("|   2. Back                            |");
    System.out.println("|--------------------------------------|");
    vendorDetails();
  }
  /**
   * vendorDetails method  process the option selected from vendorProfile.
   */
  private void vendorDetails() {
    try {
      System.out.println("Select the Option (1 or 2) : ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullVendor();
          break;
        case 2:
          customerMainMenu();
          break;
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          vendorProfile();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    vendorProfile();
  }
  // /**
  //  * menuItems method  used to display the option we had in the application.
  //  */
  private void menuItems() {
    System.out.println("|--------------------------------------|");
    System.out.println("|        Customer Food Menu Items      |");
    System.out.println("|--------------------------------------|");
    System.out.println("|       1. View Food Items             |");
    System.out.println("|       2. View All Food Items         |");
    System.out.println("|       3. Back                        |");
    System.out.println("|--------------------------------------|");

    menuItemsDetails();
  }
  /**
   * menuItemsDetails method  process the option selected from menuItems.
   */
  private void menuItemsDetails() {
    try {
      System.out.println("Select the Choice (1-3) : ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Food ID : ");
          showItem(option.nextInt());
          break;
        case 2:
          showFullMenu();
          break;
        case 3:
          customerMainMenu();
          break;
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          menuItems();
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    menuItems();
  }
  /**
   * Ordermenu method  used to display the option we had in the application.
   */
  private void orderMenu() {
    System.out.println("|--------------------------------------|");
    System.out.println("|           Customer Orders Menu       |");
    System.out.println("|--------------------------------------|");
    System.out.println("|         1. History                   |");
    System.out.println("|         2. Place Order               |");
    System.out.println("|         3. Back                      |");
    System.out.println("|--------------------------------------|");
    ordersDetails();
  }
  /** Bill generation for place ORDER - YET to add to code
   * System.out.println("Enter Customer ID : ");

   */
   /**
   * ordersDetails method  process the option selected from menuItems.
   */
  private void ordersDetails() {
    try {
      System.out.println("Select the Choice (1-2) :");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullOrders(loginCustomerID);
          break;
        case 2:
          System.out.println("Customer ID : " + loginCustomerID);
          int orcid = loginCustomerID;
          //Customer cus = CustomerFactory.showCustomer(loginCustomerID);
          System.out.println("Enter Order ID :");
          int orid = option.nextInt();
          System.out.println("Enter Food ID : ");
          int orfid = option.nextInt();

          System.out.println("Enter No. Of Items : ");
          int nitems = option.nextInt();
          java.util.Date today = new java.util.Date();
          Timestamp orderdatet = new Timestamp(today.getTime());
          String orderdate = orderdatet.toString();
          System.out.println("Order Date : " + orderdate);
          Menu foodDet = MenuFactory.showItem(orfid);
          double amtpaid = foodDet.getFoodPrice() * nitems;
          System.out.println("Amount to be Paid : " + amtpaid);
          int orvid = foodDet.getVendorId();
          System.out.println("Vendor ID : " + orvid);
          Random rand =  new Random();
          int otoken = rand.nextInt(29) + 1;
          System.out.println("Token Number : " + otoken);
          String ostatus = "Ordered";
          System.out.println("Status : " + ostatus);
          System.out.println("Enter Comment : ");
          String ocomment = option.next();
          createOrderItem(orid, orfid, orvid, orcid, nitems, orderdate, amtpaid, otoken, ostatus, ocomment);
          Bill[] billItems = OrderFactory.showOrders(orid);
          double amount = 0;
          for (Bill b:billItems) {
            if (b.getCustomerId() == orcid  && b.getOrderId() == orid) {
              if (b.getWalletAmount() >= amtpaid && b.getFoodQty() >= nitems
                  && b.getFoodId() == orfid) {
                amount = nitems * b.getFoodPrice();
                System.out.println("|--------------------------------------|");
                System.out.println("|               Bill                   |");
                System.out.println("|--------------------------------------|");
                System.out.println("|    Food Name            :" + b.getFoodName());
                System.out.println("|    Food Qty             :" + nitems);
                System.out.println("|    Food Price           :" + b.getFoodPrice());
                System.out.println("|--------------------------------------|");
                System.out.println("|  Total Amount           :" + amount);
                System.out.println("|--------------------------------------|");
                int ufq = b.getFoodQty() - nitems;
                // System.out.println("Food Qty : " + ufq);
                b.setWalletAmount(b.getWalletAmount() - amount);
                double wa = b.getWalletAmount();
                CustomerFactory.updateWallet(orcid, wa);
                MenuFactory.updateQuantity(orfid, ufq);
              } else {
                System.out.println("|----INSUFFICIENT AMOUNT IN WALLET----|");
              }
            }
          }
          System.out.println("Thank you. Visit Once again....");
          break;
        case 3:
          customerMainMenu();
        default:
          System.out.println("|------------INVALID CHOICE------------|");
          customerMainMenu();
      }
    } catch (RuntimeException e) {
      System.out.println(e);
    } catch (Exception e) {
      e.printStackTrace();
    }
    option.nextLine();
    orderMenu();
  }
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    if (menu.length == 0) {
      System.out.println("|-----------NO RECORDS FOUND-----------|");
    } else {
      System.out.println("Food ID" + "\t" + "Food Name" + "\t" + "Quantity" + "\t" + "Price" + "\t" + "Vendor ID");
      for (Menu m : menu) {
        System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t\t" + m.getFoodQty() + "\t\t" + m.getFoodPrice() + "\t" + m.getVendorId());
      }
    }
  }
  private void showItem(final int foodId) {
    Menu menu = MenuFactory.showItem(foodId);
    // if(menu.isNull()){
    //   System.out.println("|-----------NO RECORDS FOUND-----------|");
    // } else {
    System.out.println("Food ID" + "\t" + "Food Name" + "\t" + "Quantity" + "\t" + "Price" + "\t" + "Vendor ID");
    System.out.println(menu.getFoodId() + "\t" + menu.getFoodName() + "\t\t" + menu.getFoodQty() + "\t\t" + menu.getFoodPrice()
        + "\t" + menu.getVendorId());
    // }
  }
  private void createMenuItem(final int foodId, final String foodName, final int foodQty, final double foodPrice, final int vendorId) {
    int result = MenuFactory.createItem(foodId, foodName, foodQty, foodPrice, vendorId);
    if (result != 0) {
      System.out.println("|----Food Item Created Successfully----|");

    } else {
      System.out.println("|-------Cannot Create Food Item--------|");

    }
  }
  private void updateMenuItem(final Menu menu) {
    int result = MenuFactory.updateMenuItem(menu);
    if (result != 0) {
      System.out.println("|----Food Item Updated Successfully----|");
    } else {
      System.out.println("|-------Cannot Update Food Item--------|");
    }
  }
  private void deleteMenuItem(final int foodId) {
    int result =  MenuFactory.deleteItem(foodId);
    if (result != 0) {
      System.out.println("|----Food Item Deleted Successfully----|");

    } else {
      System.out.println("|-------Cannot Delete Food Item--------|");
    }
  }
  private void showFullVendor() {
    Vendor[] vendor = VendorFactory.showVendor();
    System.out.println("Vendor ID" + "\t" + "Vendor Name" + "\t" + "Vendor Email" + "\t" + "Vendor Ph. No." + "\t\t"
        + "Vendor Addr." + "\t" + "Vendor Pass.");
    for (Vendor m : vendor) {
      System.out.println(m.getVendorId() + "\t" + m.getVendorName() + "\t\t" + m.getVendorEmail()
          + "\t\t" + m.getVendorPhoneNo() + "\t\t" + m.getVendorAddress() + "\t\t" + m.getVendorPassword());
    }
  }
  private void customersDetails() {
    Customer[] customer = CustomerFactory.showAllCustomers();
    System.out.println("Customer ID" + "\t" + "Customer Name" + "\t" + "Customer Email" + "\t\t"
        + "Customer Addr." + "\t" + "Customer No." + "\t\t" + "Customer Pass" + "\t\t" + "Wallet Name"
        + "\t" + "Wallet Amt.");
    for (Customer m : customer) {
      System.out.println(m.getCustomerId() + "\t\t" + m.getCustomerName() + "\t\t" + m.getCustomerEmail()
          + "\t\t" + m.getCustomerAddress() + "\t\t" + m.getCustomerMobileNo() + "\t\t" + m.getCustomerPassword()
          + "\t\t" + m.getWalletName() + "\t\t" + m.getWalletAmount());
    }
  }
  private void showCustomer(final int customerId) {
    Customer customer = CustomerFactory.showCustomer(customerId);
    System.out.println("customer_id" + "\t" + "customer_name" + "\t" + "customer_email" + "\t" + "customer_address"
        + "\t" + "customer_mobileno" + "\t" + "customer_password" + "\t" + "wallet_name" + "\t" + "wallet_amount");
    System.out.println(customer.getCustomerId() + "\t\t" + customer.getCustomerName() + "\t\t"
        + customer.getCustomerEmail() + "\t\t" + customer.getCustomerAddress() + "\t\t" + customer.getCustomerMobileNo()
        + "\t\t" + customer.getCustomerPassword() + "\t" + customer.getWalletName() + "\t" + customer.getWalletAmount());
  }
  private void updateCustomer(final Customer customer) {
    int result = CustomerFactory.updateCustomer(customer);
    if (result != 0) {
      System.out.println("|-----Customer Updated Successfully----|");
    } else {
      System.out.println("|-------Cannot Update Customer---------|");
    }
  }
  private void createCustomerId(final int customerId, final String customerName, final String customerEmail,
      final String customerAddress, final String customerMobileNo, final String customerPassword,
      final String walletName, final double walletAmount) {
    int result = CustomerFactory.createCustomer(customerId, customerName, customerEmail, customerAddress,
        customerMobileNo, customerPassword, walletName, walletAmount);
    if (result != 0) {
      System.out.println("|----Customer Addeded Successfully-----|");
    } else {
      System.out.println("|----------Cannot Add Customer---------|");
    }
  }
  private void deleteCustomer(final int customerID) {
    int res = CustomerFactory.deleteCustomer(customerID);
    if (res != 0) {
      System.out.println("|----Customer Deleted Successfully-----|");
    } else {
      System.out.println("|-------Cannot Delete Customer---------|");
    }
  }
  private void createOrderItem(final int orderId, final int foodId, final int vendorId, final int customerId, final int noOfItems,
      final String orderDateTime, final double amountToBePaid, final int tokenNumber, final String status,
      final String comment) {
    int orderresult = OrderFactory.createOrder(orderId, foodId, vendorId, customerId, noOfItems, orderDateTime,
        amountToBePaid, tokenNumber, status, comment);
    if (orderresult != 0) {
      System.out.println("|-------Order Addeded Successfully--------|");
    } else {
      System.out.println("|-------------Cannot Add Order------------|");
    }
  }

  private void showOrderStatuses() {
    Order[] order = OrderFactory.showStatuses();
    System.out.println("Order ID" +  "\t\t" + "Status" + "\t\t" + "Comment");
    for (Order m : order) {
      System.out.println(m.getOrderId() + "\t\t" + m.getStatus() + "\t\t" + m.getComment());
    }
  }
  private void showOrderById(final int orderId) {
    Order m = OrderFactory.showOById(orderId);
    System.out.println("Order ID" + "\t" + "Food ID" + "\t\t" + "Customer ID" + "\t" + "Vendor ID" + "\t"
        + "No. Of Items" + "\t" + "Order Time" + "\t\t" + "Amount" + "\t\t" + "Token No."
        + "\t" + "Status" + "\t\t" + "Comment");
    System.out.println(m.getOrderId() + "\t\t" + m.getFoodId() + "\t\t" + m.getVendorId() + "\t\t"
        + m.getCustomerId() + "\t\t" + m.getNoOfItems() + "\t\t" + m.getOrderDateTime() + "\t\t"
        + m.getAmountToBePaid() + "\t\t" + m.getTokenNumber() + "\t\t" + m.getStatus() + "\t\t" + m.getComment());
  }
  private void showFullOrders(final int customerId) {
    Order[] order = OrderFactory.showAllOrders(customerId);
    System.out.println("Order ID" + "\t" + "Food ID" + "\t\t" + "Customer ID" + "\t" + "Vendor ID" + "\t"
        + "No. Of Items" + "\t" + "Order Time" + "\t\t" + "Amount" + "\t\t" + "Token No."
        + "\t" + "Status" + "\t\t" + "Comment");
    for (Order m : order) {
      System.out.println(m.getOrderId() + "\t\t" + m.getFoodId() + "\t\t" + m.getVendorId() + "\t\t"
          + m.getCustomerId() + "\t\t" + m.getNoOfItems() + "\t\t" + m.getOrderDateTime() + "\t\t"
          + m.getAmountToBePaid() + "\t\t" + m.getTokenNumber() + "\t\t" + m.getStatus() + "\t\t" + m.getComment());
    }
  }
/**
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}