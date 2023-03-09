package string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FirstUniqueChar{


    public static char Solution(String s) {
        TreeSet<Character> hashSet=new TreeSet();
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(hashSet.contains(c)){
                hashSet.remove(c);
            }else{
                hashSet.add(c);    
            }
        }
        if(hashSet.size()>0){
            return hashSet.iterator().next();
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(Solution("leetcode"));
        System.out.println(Solution(""));
    }
}