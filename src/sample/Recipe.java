package sample;

import java.io.Serializable;

public class Recipe implements Serializable {

    private int id;
    private String date;
    private String movie;
    private int seats;

    private Customer customer;
    private PaymentRecipe paymentRecipe;

    public Recipe(int id, String date, String movie, int seats, Customer customer, PaymentRecipe paymentRecipe) {
        this.id = id;
        this.date = date;
        this.movie = movie;
        this.seats = seats;
        this.customer = customer;
        this.paymentRecipe = paymentRecipe;
    }

    public static void createRecipe()   {
        Recipe recipe = new Recipe(
                Controller.currentID,
                Controller.choiceDate,
                Controller.choiceMovie,
                Controller.choiceSeats,
                Controller.customerMap.get(Controller.currentUser),
                Controller.payments.get(Controller.currentID)
        );
        Controller.recipesMap.put(recipe.getId(), recipe);
        Save.saveRecipe(Controller.recipesMap);
        System.out.println("Recipe has been created");
    }
    public static void createID() {
        int id = (int) (1 + 9999 * Math.random());
        if (Controller.recipeIDs.isEmpty()) {
            Controller.recipeIDs.add(id);
            System.out.println("A new ID has been created");
            Save.writeIdArray(Controller.recipeIDs);
        }
            else if(Controller.recipeIDs.contains(id))   { createID(); }

            else if(!Controller.recipeIDs.contains(id)){
                Controller.recipeIDs.add(id);
                System.out.println("A new ID has been created");
                Save.writeIdArray(Controller.recipeIDs);
            }
        else System.out.println("Error in Creating ID method");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentRecipe getPaymentRecipe() {
        return paymentRecipe;
    }

    public void setPaymentRecipe(PaymentRecipe paymentRecipe) {
        this.paymentRecipe = paymentRecipe;
    }
}
