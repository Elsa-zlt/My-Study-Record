package test;

public class test {

    private static String str = "";

    public static void main(String[] args) throws Exception {
        String num = "15919731483";
        if(checkPhoneNumber(num)) {
            System.out.println(num + "手机号合法");
        } else {
            System.out.println(num + "手机号不合法");
        }
    }

    public static boolean checkPhoneNumber(String num) {
        String myreg = "^[0-9]{11}$";
        boolean flag = true;
        if(!num.matches(myreg)) {
            System.out.println("不合法的手机号为：" + num);
            flag = false;
        }
        return flag;
    }

    public static boolean check() {
        StringBuilder sBu = new StringBuilder(str);
        String ret = sBu.reverse().toString();
        System.out.println(ret);
        System.out.println(str.equals(ret));
        return str.equals(ret);
    }

    public static boolean isPalindrome(String s1) {
        s1 = s1.toLowerCase();
        char[] s = s1.toCharArray();
        int slen = s.length;
        for(int i = 0; i < slen; i++) {
            if((s[i] >= 'a' && s[i] <= 'z')||(s[i] >= '0' && s[i] <= '9')) {
                str += s[i];
            }
        }
        return check();
    }

}
