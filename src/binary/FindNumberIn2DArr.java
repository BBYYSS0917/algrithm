package binary;

public class FindNumberIn2DArr {

    public static boolean search(int[][] matrix, int target) {
        //思路一：二分法
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length==0){
                continue;
            }
            if (matrix[i][0] <= target) {
                boolean res=binarySearch(matrix[i], target);
                if(res){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        return arr[start]==target;
    }

    public static boolean search2(int[][] arr,int target){
        //思路二：二叉搜索树解法
        int i=arr.length-1;
        int j=0;

        while(true){
            if((i<0)||(j>arr[0].length-1)){
                break;
            }
            if(arr[i][j]>target){
                i--;
            }else if(arr[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[] { 1, 4, 7, 11, 15 };
        matrix[1] = new int[] { 2, 5, 8, 12, 19 };
        matrix[2] = new int[] { 3, 6, 9, 16, 22 };
        matrix[3] = new int[] { 10, 13, 14, 17, 24 };
        matrix[4] = new int[] { 18, 21, 23, 26, 30 };

        System.out.println(search2(matrix, 5));

    }
}