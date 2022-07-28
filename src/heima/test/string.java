package heima.test;

public class string {
    public static void main(String[] args) {
        String str = "2009/20091231/18082881.jpg";
        System.out.println(str.substring(str.lastIndexOf("/") + 1));
    }
}
