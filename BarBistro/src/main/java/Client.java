import java.util.Random;

public class Client extends Person{

    IBonus bonus;


    public IBonus getBonus() {
        return bonus;
    }

    public Client(String firstName, String lastName) {

        super(firstName, lastName);

        Random random = new Random();
        int los = random.nextInt(2);
        switch (los) {
            case 0:
                bonus = new Bonus(Bistro.getTodaysDiscountAmount(), DishCategory.FlourDish);
                break;
            case 1:
                bonus = new PercentageBonus(Bistro.getTodaysDiscountRate(),DishCategory.Vege);
                break;
            default:
                bonus = new Bonus(0, DishCategory.Other);
                break;
        }



    }





}
