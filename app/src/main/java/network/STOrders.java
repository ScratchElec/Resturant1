package network;

/**
 * Created by Mahmoud Ellawatty on 24/07/2017.
 */

public class STOrders {
    private int STOrders_id;
    private int LTOrders_id;
    private int User_id;
    private float STOrders_Total;

    public int getSTOrders_id() {
        return STOrders_id;
    }

    public void setSTOrders_id(int STOrders_id) {
        this.STOrders_id = STOrders_id;
    }

    public int getLTOrders_id() {
        return LTOrders_id;
    }

    public void setLTOrders_id(int LTOrders_id) {
        this.LTOrders_id = LTOrders_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public float getSTOrders_Total() {
        return STOrders_Total;
    }

    public void setSTOrders_Total(float STOrders_Total) {
        this.STOrders_Total = STOrders_Total;
    }
}
