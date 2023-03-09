package array;

/**
 * @author Donquixote
 * @date 2023/03/05
 **/
public class SearchNumTimes {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        return 0;
    }

    public static int findLeft(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int mid = (right - left) / 2;
            if (nums[mid] > target) {
                right = mid-1;
            }
            if (nums[mid] < target) {
                left = mid+1;
            }

        }
        return 0;
    }

    public static int findRight(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search(nums, target));
    }
}
