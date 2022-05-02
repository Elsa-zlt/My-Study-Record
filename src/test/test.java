package test;

public class test {

    private static String str = "";

    public static void main(String[] args) throws Exception {
        isPalindrome("A man, a plan, a canal: Panama");
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
