import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Bistro {

    String name = "";
    static double todaysDiscountAmount = 5;
    static double todaysDiscountRate = 0.05;
    static double bigPrizeDiscountRate = 0.1;
    static double bigPrizeAmount = 10;
    List<Waiter> waiters;
    List<Order> orders;
    Set<Dish> menu;
    TreeSet<Ingredient> ingredientsMenu;


    public Bistro(String name) {
        this.name = name;
        waiters = new ArrayList<>();
        orders = new ArrayList<>();
        menu = new TreeSet<>(Comparator.comparing(Dish::getCategory));
        ingredientsMenu = new TreeSet<>(Comparator.comparing(Ingredient::getCalories));
    }

    public static double getTodaysDiscountRate() {
        return todaysDiscountRate;
    }

    public static double getTodaysDiscountAmount() {
        return todaysDiscountAmount;
    }

    public static double getBigPrizeDiscountRate() {
        return bigPrizeDiscountRate;
    }

    public static double getBigPrizeAmount() {
        return bigPrizeAmount;
    }

    public Set<Dish> getMenu() {
        return menu;
    }

    public void setMenu(TreeSet<Dish> menu) {
        this.menu = menu;
    }

    public void setMenu(Dish... dishList) {
        menu = Set.of(dishList);

    }

    public void addOrderS(Order ... orderList){
        orders.addAll(List.of(orderList));
    }

    public void addToMenu(Dish id){
        menu.add(id);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Waiter> getWaiters(){
       return waiters;
    }

    public void setWaiters(List<Waiter> waiters){
        this.waiters = waiters;
    }

    public void setWaiters(Waiter ... waiterList){
        waiters = List.of(waiterList);
    }

    public void sort(Comparator<Order> comparator){
        Collections.sort(orders, comparator);
    }

    public Iterator<Order> iterator(){
        return new OrderIterator(orders);
    }

    public double getAveragePrice(DishCategory category){
        double avaragePrice = menu.stream()
                .filter(d -> d.getCategory() == category)
                .mapToDouble(IDish::getPrice)
                .average()
                .getAsDouble();
                return avaragePrice;
    }

    public double getAveragePriceFromOrders(DishCategory category){
        double avaragePrice = orders.stream()
                .filter(d -> d.dish.getCategory() == category)
                .mapToDouble(Order::getTotalPrice)
                .average()
                .getAsDouble();
        return avaragePrice;
    }

    public void saveMenu(String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String tekst = gson.toJson(menu);
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(tekst);
        writer.close();
    }

    public void saveOrders(String fileName) throws IOException {
        Gson gson = new Gson();
        String tekst = gson.toJson(orders);
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(tekst);
        writer.close();
    }
    /*showGroupsOfDishes() – Wyświetlenie dań z menu pogrupowanych wg kategorii dań*/
    public void showGrupsOfDishes(){
        Map<DishCategory, List<Dish>> grupingMenu = menu.stream()
                .collect(Collectors.groupingBy(Dish::getCategory));
        for (Map.Entry<DishCategory, List<Dish>> i :grupingMenu.entrySet()) {
            System.out.println("Kategoria dań: "+i.getKey());
            for (Dish d : i.getValue()) {
                System.out.println("Nazwa dania: "+d.getName()+" ,cena: "+d.getPrice()+" ,kaloryczność: "+d.getCalories());
            }
        }
    }
    /*showTheMostPopularIngredients() - Wyświetlenie składników, których waga we wszystkich daniach była najwyższa*/
    public void showTheMostPopularIngredients(){
        Map<String, Double> mapOfHevyWeightIngredients = new TreeMap<String,Double>(new Comparator<Map.Entry<String,Double>>(){
        public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        /*for (Dish d:menu) {
            for (Ingredient i:d.getIngedients()) {
                if(mapOfHevyWeightIngredients.containsKey(i.getName())){
                    double w = mapOfHevyWeightIngredients.get(i.getName())+i.getWeight();
                    mapOfHevyWeightIngredients.put(i.getName(),w);
                }
                else {
                    double w = mapOfHevyWeightIngredients.get(i.getName())+i.getWeight();
                    mapOfHevyWeightIngredients.put(i.getName(),i.getWeight());
                }
            }
        }*/
        Map <String, Double> map = mapOfHevyWeightIngredients.entrySet().stream().sorted((p1,p2)->(int)(p2.getValue()-p1.getValue())).mapToInt().collect(Collectors.toList());
    }







    @Override
    public String toString() {
        return "Bistro{" +
                "name='" + name + '\'' +
                ", waiters=" + waiters +
                ", orders=" + orders +
                ", menu=" + menu +
                ", ingredientsMenu=" + ingredientsMenu +
                '}';
    }
}
