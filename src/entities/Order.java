package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(){

    }

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItems(OrderItem item){
        items.add(item);
    }

    public void removeItems(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0.0;
        for(OrderItem i:items){
            sum += i.subTotal();
        }
        return sum;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------\n");

        sb.append("ORDER SUMMARY:\n");
        sb.append("Order Moment: " + sdf.format(moment) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append("Client: " + client + "\n");
        sb.append("\nOrder Items:\n");
        for (OrderItem i: items) {
            sb.append(i + "\n");
        }
        sb.append("Total Price: $" + total() + "\n");

        sb.append("------------------------------------------------------\n");
        return sb.toString();

    }
}
