import java.util.List;

public interface IDish {

   double getWeight();
   int getCalories();
   double getPrice();
   DishCategory getCategory();
   List<Ingredient> getIngedients();
}
