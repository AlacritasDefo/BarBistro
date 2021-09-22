public class BistroException extends Exception{
    private String message;
    private IDish dish;

    public BistroException(String message, Dish dish) {
        this.message = message;
        this.dish = dish;
    }

    @Override
    public String getMessage() {
        return dish.getName() + " : " + message;
    }
}
