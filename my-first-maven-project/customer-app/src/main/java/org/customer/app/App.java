package org.customer.app;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;
import org.customer.app.factory.CustomerFactory;
import org.customer.app.factory.CustomerFactoryImpl;
import org.customer.app.model.Customer;
public class App 
{
    private static Scanner scanner=new Scanner(System.in);
	public static void main( String[] args )
    {
        try {
        	CustomerFactory impl1=new CustomerFactoryImpl(); 
        	Customer customer=null;
        	int choice;
        	do {
        		System.out.println("1. Create a Customer");
            	System.out.println("2. Display a Customer");
            	System.out.println("3. Find a Customer By ID");
            	System.out.println("4. Update a Customer");
            	System.out.println("5. Remove a Customer");
            	System.out.println("0. Exit");
            	System.out.println("Enter your choice");
            	choice=scanner.nextInt();
        		switch(choice) {
        		case 1:      			
      			  System.out.print("ID: "); int id=scanner.nextInt();
      			  System.out.print("NAME: "); String name=scanner.next();
      			  System.out.print("EMAIL: "); String email=scanner.next();
      			  
      			  
      			  customer=impl1.createCustomer(id, name, email);
      			  System.out.println(customer.toString());
      			  break;
        		case 2:
        			List<Customer> list=impl1.getAllCustomer();
        			for(Customer c:list) {
        				System.out.println(c);
        			}
        		break;
        		case 3:
            	System.out.println("Enter Name to search:");
            	String name1=scanner.next();
            	impl1.findById(name1);
            	break;
        		case 4:
					System.out.print("enter id to update: ");
					id = scanner.nextInt();
					impl1.update(id);
					break;
        		case 5:
        			System.out.print("enter id to delete: ");
					id = scanner.nextInt();
					impl1.deleteCust(id);
					break;
				case 0:
					System.out.println("bye!");
					System.exit(0);
				default:
					System.out.println("invalid choice..");
					break;
				}

			} while (choice != 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}