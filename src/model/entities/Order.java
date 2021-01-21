package model.entities;

import model.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Joao
 */
public class Order {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private Date moment;
    private OrderStatus status;
    
    private List<OrderItem> orderItem = new ArrayList<>(); 
    private Client client;
    
    public Order() {
    }
    
    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
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
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public List<OrderItem> getOrderItem() {
        return orderItem;
    }
    
    public void addItem(OrderItem item) {
         orderItem.add(item);
    }
    
    public void removeItem(OrderItem item) {
         orderItem.remove(item);
    }
    
    public Double total() {
        double sum = 0;
        for(OrderItem o : orderItem) {
            sum += o.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");
        for(OrderItem item : orderItem) {
            sb.append(item + "\n");           
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
