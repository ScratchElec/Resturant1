package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class Favorit_Restaurants {
    private int Favorit_Restaurants_id;
    private int User_id;
    private int Restaurant_id;

    public int getFavorit_Restaurants_id() {
        return Favorit_Restaurants_id;
    }

    public void setFavorit_Restaurants_id(int favorit_Restaurants_id) {
        Favorit_Restaurants_id = favorit_Restaurants_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getRestaurant_id() {
        return Restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        Restaurant_id = restaurant_id;
    }
}
