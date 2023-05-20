package Restaurant_System;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;



public class AppMain {
	

    public static void main(String[] args) {
        //System.out.println(restaurant.TableList());
    	Scanner scanner = new Scanner(System.in);
    	
        Resturant restaurant = new Resturant(1, "Pizza Palace", "123 Main St");
        User user = null;
        

        System.out.println("Welcome to " + restaurant.getName());

        while(true) {
        	 try {
                 System.out.println("Please select an option:");
                 System.out.println("1. subscribe");
                 System.out.println("2. Log in for subscribed clients");
                 System.out.println("3. Log in for non subscribed clients");
                 System.out.println("4. Exit");
                 int option = scanner.nextInt();
                 String password,name,lastname,phone_number,adresse,email;
                 scanner.nextLine();
                 switch(option) {
                 	case 1:
                        System.out.println("Please enter your name:");
                        name = scanner.nextLine();

                        System.out.println("Please enter your last name:");
                        lastname = scanner.nextLine();

                        System.out.println("Please enter your phone number:");
                        phone_number = scanner.nextLine();

                        System.out.println("Please enter your address:");
                        adresse = scanner.nextLine();
                        System.out.println("Please enter your email:");
                        email = scanner.nextLine();

                        System.out.println("Please enter your password:");
                        password = scanner.nextLine();
                        UserAbonnee temp = new UserAbonnee(name, lastname, phone_number, adresse, email, password);
                        user = temp;
                        restaurant.addUser(temp);
                        break;
                 	case 2:
                 		 System.out.print("Enter your email: ");
                         email = scanner.nextLine();
                         System.out.print("Enter your password: ");
                         password = scanner.nextLine();
                         ArrayList<UserAbonnee> users = restaurant.getUsers();
                         boolean trouve = false;
                         //verif user infos
                         for(UserAbonnee u:users) {
                        	 if(email.equals(u.getMail()) && password.equals(u.getMotDePasse())) {
                         		user=u;
                         		trouve = true;
                         	}
                         }
                         if(trouve) {
                        	 menuClient(user, restaurant);
                         }else {
                        	 System.out.println("user not found , try again!");
                         }
                         
                         break;
                 	case 3:
                        System.out.println("Please enter your name:");
                        name = scanner.nextLine();

                        System.out.println("Please enter your last name:");
                        lastname = scanner.nextLine();

                        System.out.println("Please enter your phone number:");
                        phone_number = scanner.nextLine();

                        System.out.println("Please enter your address:");
                        adresse = scanner.nextLine();
                        
                        user = new UserNonAbonne(name, lastname, phone_number, adresse);
                        menuClient(user , restaurant);
                        break;
                 	case 4:
                        System.out.println("Thank you for visiting our restaurant!");
                        return;
                 }
                 
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }}

        
}
    
    
    
    
	public static void menuClient(User user , Resturant restaurant) {
		Scanner scanner = new Scanner(System.in);
		Boolean f=true;
		while (f) {
			
            try {
                System.out.println("Please select an option:");
                System.out.println("1. See Menu");
                System.out.println("2. See tables that are available for reservation");
                System.out.println("3. Order");
                System.out.println("4. See your orders");
                System.out.println("5. Reserve a table (only subcribers)");
                System.out.println("6. Unreserve the tables (only subcribers)");
                System.out.println("7. Exit");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println(restaurant.menuPizza());
                        break;

                    case 2:
                        System.out.println(restaurant.TableList());
                        break;
                    case 3:
                    	System.out.println(restaurant.menuPizza());
                            System.out.println("Please select a pizza:");
                            int pizzaId = scanner.nextInt();
                            scanner.nextLine();

                            Pizza selectedPizza = restaurant.getPizzaById(pizzaId);

                            if (selectedPizza == null) {
                                System.out.println("Invalid pizza selection.");
                            } else {
                                scanner.nextLine();
                                System.out.println("Please select the size(from 1 to 3):");
                                System.out.println("1. small");
                                System.out.println("2. medium");
                                System.out.println("3. large");
                                int choix = scanner.nextInt();
                                String size;
                                if(choix ==1) {
                                	size = "small";
                                }else if(choix ==2) {
                                	size = "medium";
                                }else {
                                	size = "large";
                                }
                                restaurant.commander(pizzaId, size, user);

                                System.out.println("Thank you for your order!");
                                
                                
                            }
                        
                        break;

                    case 4:
                    	System.out.println("+-----------------------------+\n"
                    			+"| your Orders : \n"); 
                    	user.displayCommandes();
                    	break;
                    case 5:
                    	
                    	if(user instanceof UserAbonnee) {
                    			
                        System.out.println("Please select a table size:");

                            int tableSize = scanner.nextInt();
                            scanner.nextLine();

                            restaurant.reserver(tableSize, user);
                    		}else {
                    			System.out.println("you need to be subscribed to reserve a table :");
                    		}
                    		break;
                    
                    case 6:
                    	restaurant.Unreserve(user);
                    	break;
                    case 7:
                    	return;

                    default:
                    	System.out.println("Invalid option.");
                    
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
	}}