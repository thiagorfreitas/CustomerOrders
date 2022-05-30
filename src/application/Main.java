package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(clientName,clientEmail,birthDate);

        System.out.println();
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String orderStatus = sc.next();
        System.out.print("How many items to this order? ");
        int numberOfItems = sc.nextInt();
        Order order = new Order(OrderStatus.valueOf(orderStatus), client);

        System.out.println();
        for (int i = 0 ; i < numberOfItems ; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product Name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(product, productQuantity, productPrice);
            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println(order);

    }
}
