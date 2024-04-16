public class TreeHeight {

    public static void main(String[] args) {
        int[] tree = {81, 13, 36, 65, 38, 69};
        System.out.println(find_height(tree, 6, 47));
    }

    static int find_height(int[] tree, int n, int k)
    {
        if(k ==0) {
            return 0;
        }

        if(tree == null) {
            return -1;
        }

        int high =0;

        for (int value : tree) {
            if (value > high) {
                high = value;
            }
        }

        int low =0;

        while(low <= high){
            int mid = low + (high-low)/2;
            int sum = 0;
            for (int i : tree) {
                if (i > mid) {
                    sum += i - mid;
                    System.out.println("Sum = " + sum + " i=" + i);

                }
            }

            if(sum == k) {
                return mid;
            } else if( sum < k) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
