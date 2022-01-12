public class PercentageBonus implements IBonus{

    double discountRate;
    DishCategory category;

    public PercentageBonus(double discountRate, DishCategory category) {
        this.discountRate = discountRate;
        this.category = category;
    }

    @Override
    public double discount(double amount) {
        return amount*discountRate;
    }

    @Override
    public DishCategory getCategory() {
        return category;
    }
}