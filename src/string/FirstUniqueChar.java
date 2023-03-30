package string;

import java.util.*;

public class FirstUniqueChar {

    public static char Solution(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        for (char c : chars) {
            if (map.get(c)==1) {
                return c;
            }
        }

        return ' ';

    }


    public static char Solution1(String s){

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for(char c :s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }

        for(char c:map.keySet()){
            if(map.get(c)==1){
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(Solution1("leetcode"));
        System.out.println(Solution1(""));
    }
}