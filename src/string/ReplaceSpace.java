package string;

/**
 * @author BaiJY
 * @date 2023/03/02
 **/
public class ReplaceSpace {

    public static String replaceString(String s) {
//        s.replace(" ", "%20");
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();


        for (char c : chars) {
            if (c == " ".charAt(0)) {
                builder.append("%20");
                continue;
            }
            builder.append(String.valueOf(c));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceString("We are happy."));
    }
}
