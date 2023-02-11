package array;

import utils.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author BaiJY
 * @date 2023/02/10
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        Utils.printIntArr(twoSum2(nums, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;

                    break;
                }
            }
        }
        return res;
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 寻找之前的target-x
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int needVal = target - nums[i];
            if (map.containsKey(needVal)) {
                return new int[]{i, map.get(needVal)};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


}
