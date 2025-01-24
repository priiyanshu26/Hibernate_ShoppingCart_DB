package com.jsp.hibernate.quickstart1;

import java.util.Scanner;
import com.jsp.hibernate.quickstart1.ShoppingDao.ShoppingCartDao;

/**
 * Main application to interact with the ShoppingCartDao.
 */
public class App {
    public static void main(String[] args) {
        ShoppingCartDao shoppingCartDao = new ShoppingCartDao();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nShopping Cart Operations:");
            System.out.println("1. Add Product");
            System.out.println("2. Add User with Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product");
            System.out.println("5. Find All Products in Cart");
            System.out.println("6. Exit");
            System.out.print("Choose an operation: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shoppingCartDao.addproduct();
                    break;
                case 2:
                    shoppingCartDao.adduserwithcart();
                    break;
                case 3:
                    shoppingCartDao.addproduct();
                    break;
                case 4:
                    shoppingCartDao.addproduct();
                    break;
                case 5:
                    shoppingCartDao.findallproductincart();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        }

        
    }
}
