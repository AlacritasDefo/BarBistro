import java.time.LocalDateTime;

public class Order {

    LocalDateTime time;
    IDish dish;
    Client client;
    Waiter waiter;

    public Order(IDish dish, Client client, Waiter waiter) {
        this.time = LocalDateTime.now();
        this.dish = dish;
        this.client = client;
        this.waiter = waiter;
        waiter.addTotalRevenue(dish.getPrice());
    }

    public Double getTotalPrice() {
        waiter.addTotalRevenue(dish.getPrice());
        return dish.getPrice();
//        TODO: uwzględnić Bonusy
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", dish=" + dish +
                ", client=" + client +
                ", waiter=" + waiter +
                '}';
    }
}
