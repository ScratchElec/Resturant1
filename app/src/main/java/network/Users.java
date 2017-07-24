package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class Users {
    private int Users_id;
    private String User_Name;
    private String User_Phone;
    private String User_Photo_URL;
    private String User_Mail;
    private int User_Type; //1-admin , 2-rest , 3-regular


    public int getUsers_id() {
        return Users_id;
    }

    public void setUsers_id(int users_id) {
        Users_id = users_id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }

    public String getUser_Photo_URL() {
        return User_Photo_URL;
    }

    public void setUser_Photo_URL(String user_Photo_URL) {
        User_Photo_URL = user_Photo_URL;
    }

    public String getUser_Mail() {
        return User_Mail;
    }

    public void setUser_Mail(String user_Mail) {
        User_Mail = user_Mail;
    }

    public int getUser_Type() {
        return User_Type;
    }

    public void setUser_Type(int user_Type) {
        User_Type = user_Type;
    }
}
