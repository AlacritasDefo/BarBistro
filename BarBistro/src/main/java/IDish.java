import java.util.List;

public interface IDish {

   double getWeight();
   int getCalories();
   double getPrice();
   String getName();
   DishCategory getCategory();
   List<Ingredient> getIngedients();
}
