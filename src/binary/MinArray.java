package binary;

public class MinArray {
    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                end = mid;
            } else {
                //find min
                return findMin(numbers, start, end);
            }
        }
        return numbers[start];
    }

    public static int findMin(int[] numbers,int start,int end){
        int result=numbers[start];

        for(int i=start;i<=end;i++){
            if(numbers[i]<result){
                result=numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(minArray(new int[] { 2, 2, 2, 0, 1 }));
    }
}
