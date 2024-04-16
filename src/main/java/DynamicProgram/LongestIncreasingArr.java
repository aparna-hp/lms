package DynamicProgram;

public class LongestIncreasingArr {

    public static void main(String[] args) {
        int[] input = {7,3,10,4,5,9,11,2,1,13,6,15};
        int[] dynamicArr = new int[input.length];
        System.out.println(longestIncreasing(input, 0, 0));
    }

    public static int longestIncreasing(int[] input, int index, int longest) {
        if(input.length <=1 || index == input.length -1) {
            return Math.max(longest,1);
        }

        int length = 1;
        int prev = input[index];
        for(int i=index+1; i< input.length; i++){
            if(input[i] > prev) {
                length++;
                prev = input[i];
            }
        }
        System.out.println("Longest at index " + index + " = " + length);
        return longestIncreasing(input, index+1, Math.max(longest, length));

    }
}
