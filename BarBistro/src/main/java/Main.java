public class Main {
    public static void main(String[] args) {

        Ingredient i1 = new Ingredient("Jabłko",3.5,200);
        Ingredient i2 = new Ingredient("Jajko",0.3,50);
        Ingredient i3 = new Ingredient("Mąka",1,600);

        Dish dish1 = new Dish("Jabłecznik",15.40,DishCategory.FlourDish);
        dish1.addIngredients(i1,i2,i3);
        System.out.println(" Kalorie dania " + dish1.getName() + " to " + dish1.getCalories() + " , waga dania to " +dish1.getWeight() + " kg");

    }
}