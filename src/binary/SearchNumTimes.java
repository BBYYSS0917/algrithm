package binary;

public class SearchNumTimes {

    public static int search(int[] nums, int target) {
        int left = findBoundry(nums, target, true);
        int right = findBoundry(nums, target, false);
        return right-left-1;
    }

    public static int findBoundry(int[] nums, int target, boolean left) {
        int l = 0;
        int r = nums.length - 1;

        while (r >= l) {
            int mid = (r + l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                if (left) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }

        return left ? r : l;
    }


    public static void main(String[] args) {
        int[] arr1=new int[]{5,7,7,8,8,10};
        int[] arr2=new int[]{8,8,8,8,8,8,8,8};
        System.out.println(search(arr1, 8));
        System.out.println(search(arr1, 8));
    }

}
