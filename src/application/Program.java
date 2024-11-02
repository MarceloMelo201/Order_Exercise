package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(new Client(name, email, birthDate), OrderStatus.valueOf(status), new Date());

        for(int i = 0; i < n; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            order.addItem(new OrderItem(quantity, price, new Product(productName, price)));
        }

        System.out.println(order);

        sc.close();

    }
}
