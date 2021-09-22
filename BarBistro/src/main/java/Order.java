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
    }

    public Double getTotalPrice() {
        waiter.addTotalRevenue(dish.getPrice());
        return dish.getPrice();
//        TODO: uwzględnić Bonusy
    }
}
