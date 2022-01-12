public class Waiter extends Person {

    double totalRevenue;

    public Waiter(String firstName, String lastName) {
        super(firstName, lastName);
        this.totalRevenue = 0;
    }

    public void addTotalRevenue(double amount) {
        totalRevenue += amount;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "totalRevenue=" + totalRevenue +
                '}';
    }
}