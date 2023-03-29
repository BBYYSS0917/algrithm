package binary;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        if(nums[0]==1) return 0;
        int index = 0;
        for (int num : nums) {
            if (num != index) {
                return index;
            }
            index++;
        }
        return nums.length;
    }

    public static int missingNumber1(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(right+left)/2;
            if(nums[mid]==mid){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[] { 0, 1, 2 }));
        System.out.println(missingNumber1(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 9 }));
    }
}