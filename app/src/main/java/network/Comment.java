package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class Comment {
    private int Comment_id;
    private String Comment_Text;
    private int Comment_Parent_id;
    private int User_id;
    private int Restaurant_id;

    public int getComment_id() {
        return Comment_id;
    }

    public void setComment_id(int comment_id) {
        Comment_id = comment_id;
    }

    public String getComment_Text() {
        return Comment_Text;
    }

    public void setComment_Text(String comment_Text) {
        Comment_Text = comment_Text;
    }

    public int getComment_Parent_id() {
        return Comment_Parent_id;
    }

    public void setComment_Parent_id(int comment_Parent_id) {
        Comment_Parent_id = comment_Parent_id;
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
