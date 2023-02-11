package array;

/**
 * @author Donquixote
 * @date 2023/02/11
 **/
public class LongestPrefix {
    public static void main(String[] args) {

//        System.out.println("12345".substring(0, 0).equals(""));
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return prefix;
                }
            }
        }

        return prefix;
    }
}
