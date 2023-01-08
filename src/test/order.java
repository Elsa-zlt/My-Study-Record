package test;

/**
 * @ClassName : order  //类名
 * @Author : elsa //作者
 */
public class order {

    int id;
    int price;

    public order(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
