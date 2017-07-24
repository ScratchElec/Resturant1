package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class Category {
    private int Category_id;
    private String Category_Name;
    private int Category_Available;
    private int Restaurant_id;

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    public int getCategory_Available() {
        return Category_Available;
    }

    public void setCategory_Available(int category_Available) {
        Category_Available = category_Available;
    }

    public int getRestaurant_id() {
        return Restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        Restaurant_id = restaurant_id;
    }
}
