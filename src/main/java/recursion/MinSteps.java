package recursion;

public class MinSteps {

    public static void main(String[] args) {

        System.out.println(findMinSteps(0, 1, 5, 0));
        System.out.println(findMinStepsOnInfiniteLine( 2));


    }

    public static int findMinSteps(int start, int jump, int target, int steps) {
        System.out.println("Start= " + start + " jump=" + jump + " steps=" + steps) ;

        if (start == target) {
            return steps;
        }

        if (Math.abs(start) > Math.abs(target)) {
            return Integer.MAX_VALUE;
        }

        return Math.min(findMinSteps(start + jump, jump + 1, target, steps + 1),
                findMinSteps(start - jump, jump + 1, target, steps + 1));

    }

    public static int findMinStepsOnInfiniteLine(int target) {
        int sum = 0;
        int step =0;
        while (sum < target){
            sum += ++step;
        }

        if(sum == target || (sum-target % 2 == 0)) {
            return step;
        } else{
            sum += ++step;
            if(sum-target %2 == 0) {
                return step;
            } else
                return step+1;
        }
    }
}
