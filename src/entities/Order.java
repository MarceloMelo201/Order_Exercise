package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(){}

    public Order(Client client, OrderStatus status, Date moment) {
        this.client = client;
        this.status = status;
        this.moment = moment;
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

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void addItem(OrderItem item){
        orderItem.add(item);
    }

    public void removeItem(OrderItem item){
        orderItem.remove(item);
    }

    public Double total(){
        double sum = 0;
        for(OrderItem i: orderItem){
            sum += i.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("ORDER SUMMARY:")
                .append("\nOrder moment: ").append(sdf1.format(moment))
                .append("\nOrder status: ").append(status)
                .append("\nClient: ").append(client.getName())
                .append(" (").append(sdf1.format(moment)).append(") - ")
                .append(client.getEmail())
                .append("\nOrder items:");

        for (OrderItem o : orderItem) {
            print.append("\n").append(o.toString());
        }

        double total = total();

        print.append("\nTotal price: $").append(total);
        return print.toString();
    }


}
