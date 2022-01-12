public class Bonus implements IBonus{

    private double discountQuote;
    private DishCategory category;
    public Bonus(double discountQuote, DishCategory category) {
        this.discountQuote = discountQuote;
        this.category = category;
    }

/**
 * Metoda zwraca wartość discountQuote jeżeli jest on nie większy niż połowa ceny dania
 * w przeciwnym razie zwraca złotówkę
 */

    @Override
    public double discount(double amount) {
        if (amount>2*discountQuote)
            return discountQuote;
        else
            return 1;
    }

    @Override
    public DishCategory getCategory() {
        return null;
    }
}
