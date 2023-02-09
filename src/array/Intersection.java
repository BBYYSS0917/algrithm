package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Donquixote
 * @date 2023/02/09
 **/
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        printArr(intersect(nums1, nums2));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        List<Integer> res = new ArrayList<>();

        for (int num:nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                int count = map.get(num) - 1;
                map.put(num, count);
            }
        }

        int[] arr = new int[res.size()];
        int index = 0;
        for (Integer num : res) {
            arr[index] = num;
            index++;
        }


        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
