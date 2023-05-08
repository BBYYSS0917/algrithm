package array;

/**
 * @author Donquixote
 * @date 2023/03/05
 **/
public class SearchNumTimes {
    public static int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static int findRightBoundry(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(r>=l){
            int mid=(l+r)/2;
            if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }


    public static int binarySearch(int[] nums,int target,boolean isLeft){
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {

            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                if(isLeft){
                    right-=1;
                }else{
                    left+=1;
                }
            }
        }
        return isLeft?left:right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,8,8,8,8,8};
        int target = 8;

        System.out.println(search(nums, target));
    }
}
