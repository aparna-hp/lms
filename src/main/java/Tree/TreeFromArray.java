package Tree;

public class TreeFromArray {

    int[] treeArr;
    int N;

    public static void main(String[] args){
        int N = 8;
        TreeFromArray tree = new TreeFromArray(7);
        tree.treeArr = new int[]{4, 5, 3, 4, 0, 6, 1};
        System.out.println("Sum = " + tree.sumOfLeaves());
    }

    public TreeFromArray(int N){
        treeArr = new int[N];
        this.N = N;
    }

    public int sumOfLeaves(){
        int sum =0;
        for(int i=0; i<N; i++) {
            int leftChildIndex = 2*i +1;
            int rightChildIndex = 2*i +2;
            if((leftChildIndex >= N || treeArr[leftChildIndex] == 0) &&
                    (rightChildIndex >= N || treeArr[rightChildIndex] == 0)) {
                sum += treeArr[i];
            }
        }
        return sum;
    }


}
