import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bistro bistro = new Bistro("bistro u kaszuba");

        Ingredient i1 = new Ingredient("Jabłko",3.5,200);
        Ingredient i2 = new Ingredient("Jajko",0.3,50);
        Ingredient i3 = new Ingredient("Mąka",1,600);
        Ingredient i4 = new Ingredient("Stek wołowy", 0.75, 900);
        Ingredient sk1 = new Ingredient("ziemniaki", 250.0, 300);
        Ingredient sk2 = new Ingredient("cebula", 50.0, 100);

        Dish d4 = new Dish("pulpet poczdamski", 18.20, DishCategory.Meat);


        Dish dish1 = new Dish("Jabłecznik",15.40,DishCategory.FlourDish);
        Dish dish2 = new Dish("Kotel sojowy", 20.0, DishCategory.Vege);
        bistro.addToMenu(dish1);
        bistro.addToMenu(dish2);
        bistro.addToMenu(d4);
        try {
            dish1.addIngredients(i1,i2,i3);
        } catch (BistroException e) {
            System.out.println(e.getMessage());
        }
        try {
            dish2.addIngredients(i3);;
        } catch (BistroException e) {
            System.out.println(e.getMessage());
        }
        try {
            d4.addIngredients(sk1, sk2);
        } catch (BistroException e) {
            System.out.println(e.getMessage());
        }
        SideDish sd2 = new SideDish("sok mango", 200, 30, 4.7,d4);
        System.out.println(" Kalorie dania " + dish1.getName() + " to " + dish1.getCalories() + " , waga dania to " +dish1.getWeight() + " kg");
        System.out.println(" Kalorie dania " + dish2.getName() + " to " + dish2.getCalories() + " , waga dania to " +dish2.getWeight() + " kg");
        System.out.println(" Kalorie dania " + d4.getName() + " to " + d4.getCalories() + " , waga dania to " +d4.getWeight() + " kg");
        System.out.println(" Kalorie dania " + sd2.getName() + " to " + sd2.getCalories() + " , waga dania to " +sd2.getWeight() + " kg");


        try {
            bistro.saveMenu("menu.json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        bistro.showGrupsOfDishes();
    }


}