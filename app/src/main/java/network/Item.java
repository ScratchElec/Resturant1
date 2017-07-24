package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class Item {
    private int Item_id;
    private String Item_Name;
    private String Item_Content;
    private float Item_Small_Price;
    private float Item_Medium_Price;
    private float Item_Large_Price;
    private int Item_Is_Spicy;
    private int Category_id;


    public int getItem_id() {
        return Item_id;
    }

    public void setItem_id(int item_id) {
        Item_id = item_id;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getItem_Content() {
        return Item_Content;
    }

    public void setItem_Content(String item_Content) {
        Item_Content = item_Content;
    }

    public float getItem_Small_Price() {
        return Item_Small_Price;
    }

    public void setItem_Small_Price(float item_Small_Price) {
        Item_Small_Price = item_Small_Price;
    }

    public float getItem_Medium_Price() {
        return Item_Medium_Price;
    }

    public void setItem_Medium_Price(float item_Medium_Price) {
        Item_Medium_Price = item_Medium_Price;
    }

    public float getItem_Large_Price() {
        return Item_Large_Price;
    }

    public void setItem_Large_Price(float item_Large_Price) {
        Item_Large_Price = item_Large_Price;
    }

    public int getItem_Is_Spicy() {
        return Item_Is_Spicy;
    }

    public void setItem_Is_Spicy(int item_Is_Spicy) {
        Item_Is_Spicy = item_Is_Spicy;
    }

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }
}
