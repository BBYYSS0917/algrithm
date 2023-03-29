package array;

/**
 * @author Donquixote
 * @date 2023/03/05
 **/
public class SearchNumTimes {
    public static int search(int[] nums, int target) {
        int left=binarySearch(nums, target,true);
        System.out.println("left===="+left);
        int right=binarySearch(nums, target, false);
        System.out.println("right===="+right);
        if(nums[left]>target||nums[right]<target){
            return 0;
        }
        if(nums[left]==nums[right]){
            return right-left+1;
        }
        return right-left;
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
        int[] nums = new int[]{1,2,3};
        int target = 1;
        System.out.println(binarySearch(nums, target,false));
    }
}
