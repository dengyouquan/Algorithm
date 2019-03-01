/**
 * @author dengyouquan
 * @createTime 2019-02-27
 **/
public class Main {
    public static void main(String[] args) {
        String str = "abc";
        String str1 = new String("abc");
        char data[] = {'a', 'b', 'c'};
        String str2 = new String(data);
        System.out.println(str == str1);
        System.out.println(str == str2);
    }
}
