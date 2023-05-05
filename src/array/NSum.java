package array;

import java.util.*;

public class NSum {

    public static List<List<Integer>> nSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }

    public static List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) {
            return res;
        }
        if (n == 2) {
            int low = start;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left)
                        low++;
                } else if (sum > target) {
                    while (low < high && nums[high] == right)
                        high--;
                } else {
                    res.add(new ArrayList<>(List.of(nums[low], nums[high])));
                    while (low < high && nums[low] == left)
                        low++;
                    while (low < high && nums[high] == right)
                        high--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> tuples = nSum(nums, target - nums[i], n - 1, i + 1);
                for (List<Integer> item : tuples) {
                    item.add(nums[i]);
                    // 考虑溢出问题
                    long total = item.stream().mapToLong(Long::valueOf).sum();
                    if (total != Long.valueOf(target)) {
                        continue;
                    }
                    res.add(item);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int tmp = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == tmp) {
                continue;
            }
            tmp = nums[i];
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - tmp);
            for (List<Integer> item : tuples) {
                item.add(tmp);
                res.add(item);
            }
        }

        return res;
    }

    // 计算两数之和的不重复元组
    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int low = start;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target) {
                int tmp = nums[low];
                while (low < high && nums[low] == tmp)
                    low++;
            } else if (sum > target) {
                int tmp = nums[high];
                while (low < high && nums[high] == tmp)
                    high--;
            } else {
                res.add(new ArrayList<>(List.of(nums[low], nums[high])));
                int tmpLow = nums[low];
                int tmpHigh = nums[high];
                while (low < high && nums[low] == tmpLow)
                    low++;
                while (low < high && nums[high] == tmpHigh)
                    high--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1000000000, -1000000000, 1000000000, -1000000000, -1000000000 };

        List<List<Integer>> res = nSum(nums, 294967296);
        for (List<Integer> l : res) {
            l.stream().forEach(System.out::println);
            System.out.println("=============");
        }
    }

}
