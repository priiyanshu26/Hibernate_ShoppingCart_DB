package com.jsp.hibernate.quickstart1.ShoppingDao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.quickstart1.entity.Cart;
import com.jsp.hibernate.quickstart1.entity.Product;
import com.jsp.hibernate.quickstart1.entity.User;



public class ShoppingCartDao {
	Scanner sc=new Scanner(System.in);
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class).addAnnotatedClass(User.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public void addproduct() {
		Product p=new Product();

		System.out.println("ENTER THE PRODUCTiD");
		p.setProductid(sc.nextInt());
		System.out.println("ENTER THE PRODUCT NAME");
		p.setProductname(sc.next());
		System.out.println("ENTER THE PRODUCT BRAND");
		p.setProductbrand(sc.next());
		System.out.println("ENTER THE PRODUCT PRICE");
		p.setProductprice(sc.nextInt());


		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(p);
		tran.commit();
		session.close();

		System.out.println("data inserted successfully");

	}

	public void adduserwithcart() {
		Cart c=new Cart();

		User u=new User();
		System.out.println("ENTER THE USER ID");
		u.setUserid(sc.nextInt());
		System.out.println("ENTER THE USER NAME");
		u.setUsername(sc.next());
		System.out.println("ENTER THE EMAIL");
		u.setEmail(sc.next());
		System.out.println("ENTER THE LOCATION");
		u.setLocation(sc.next());
		System.out.println("ENTER THE CITY");
		u.setCity(sc.next());

		System.out.println("ENTER THE CART ID");
		c.setCartid(sc.nextInt());


		u.setCart(c);


		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(c);
		session.save(u);

		tran.commit();
		session.close();


		System.out.println("data inserted successfully");
	}


	public void addproductcart() {

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter the product id");

		Product p=session.get(Product.class, sc.nextInt());
		if(p!=null) {
			System.out.println("Enter the User id");
			User u=session.get(User.class, sc.nextInt());
			if(u!=null) {
				Cart c=u.getCart();
				List<Product> plist=c.getProduct();
				plist.add(p);
				session.update(c);
				System.out.println("product added to the cart");
			}
			else {
				System.err.println("user not avaiable");
			}
		}
		else {
			System.err.println("product not found");
		}

		tran.commit();
		session.close();


		System.out.println("data inserted successfully");

	}

	public void removeproduct() {

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter the product id");

		Product p=session.get(Product.class, sc.nextInt());
		if(p!=null) {
			session.delete(p);
			tran.commit();
			session.close();
			System.out.println("Data Deleted Succeefully");
		}

		else {
			System.err.println("Employee not found by id");
		}

	}

	public void findallproductincart() {

		Session session=sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter product id");
		Product p=session.get(Product.class, sc.nextInt());

		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("Employee not found by id");
		}
		tran.commit();
		session.close();
	}


}
