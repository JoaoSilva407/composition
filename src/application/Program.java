package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(input.next());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());
        
        Order order = new Order(new Date(), status, client); 
        
        System.out.print("How many item to this order: ");
        int num = input.nextInt();
        for(int i=1; i<=num; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            input.nextLine();
            String nameItem = input.nextLine();
            System.out.print("Product price: ");
            double price = input.nextDouble();
            
            Product product = new Product(nameItem, price); 
            
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }
        
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    
        input.close();        
    }    
}
