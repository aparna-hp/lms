//Smallest number to make Array sum at most K by dividing each element

public class MinNumToDivide {

    public static void main(String[] args){
        int[] arr = {5,6,7,8};
        int k = 4;

        System.out.println(findMinNumToDivide(arr, k));
    }

    public static int findMinNumToDivide(int[] arr, int k) {

        int low =1;
        int high = arr[0];

        for(int I: arr) {
            if(high < I) {
                high = I;
            }
        }

        while(low <= high) {
            int mid = low + (high-low)/2;
            int sum = computeSum(arr, mid);

            if(sum == k) {
                return mid;
            }

            if(sum < k){
                high = mid-1;
            } else {
                low = mid+1;
            }

        }
        return -1;
    }

    public static int computeSum(int[] arr, int mid) {
        int sum =0;
        for(int I : arr) {
            sum += I/mid;
            if (I % mid > 0) {
                sum++;
            }
        }
        System.out.println(" sum =" + sum + " for mid = " + mid);
        return sum;
    }

}