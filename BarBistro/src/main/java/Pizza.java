public class Pizza extends Dish{
    private int size;

    public Pizza(String name, Double price, DishCategory category, int size) {
        super(name, price, category);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
