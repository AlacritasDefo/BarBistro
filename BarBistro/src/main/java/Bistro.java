import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Bistro {

    String name = "";
    static double todaysDiscountAmount = 5;
    static double todaysDiscountRate = 0.05;
    static double bigPrizeDiscountRate = 0.1;
    static double bigPrizeAmount = 10;
    List<Waiter> waiters;
    List<Order> orders;
    TreeSet<IDish> menu;
    TreeSet<Ingredient> ingredientsMenu;

    public Bistro(String name) {
        this.name = name;
        waiters = new ArrayList<>();
        orders = new ArrayList<>();
        menu = new TreeSet<>();
        ingredientsMenu = new TreeSet<>();
    }

    public static double getTodaysDiscountRate() {
        return todaysDiscountRate;
    }

    public static double getTodaysDiscountAmount() {
        return todaysDiscountAmount;
    }

    public static double getBigPrizeDiscountRate() {
        return bigPrizeDiscountRate;
    }

    public static double getBigPrizeAmount() {
        return bigPrizeAmount;
    }

    @Override
    public String toString() {
        return "Bistro{" +
                "name='" + name + '\'' +
                ", waiters=" + waiters +
                ", orders=" + orders +
                ", menu=" + menu +
                ", ingredientsMenu=" + ingredientsMenu +
                '}';
    }
}
