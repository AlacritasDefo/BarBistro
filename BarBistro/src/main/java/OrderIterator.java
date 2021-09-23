import java.util.Iterator;
import java.util.List;

public class OrderIterator implements Iterator<Order> {

    List<Order> orders;
    int current;

    public OrderIterator(List<Order> orders) {
        current = 0;
        this.orders = orders;
    }


    @Override
    public boolean hasNext() {
        if (orders.size() > current)
            return true;
        else
            return false;
    }

    @Override
    public Order next() {
        return orders.get(current++);
    }
}
