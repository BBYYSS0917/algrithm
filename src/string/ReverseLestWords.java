package string;

/**
 * @author BaiJY
 * @date 2023/03/02
 **/
public class ReverseLestWords {

    public static String reverseLeftWords(String s, int n) {

        char[] originChars = s.toCharArray();
        char[] newChars = new char[originChars.length];
        int index = 0;
        for (int i = n; i < originChars.length; i++) {
            newChars[index] = originChars[i];
            index++;
        }
        for (int i = 0; i < n; i++) {
            newChars[newChars.length - n + i] = originChars[i];
        }


        StringBuilder builder = new StringBuilder();
        for (char c : newChars) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        //rotate in part

        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt((i + n) % s.length());
        }


        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseLeftWords2("abcdefg", 2));
    }

}
