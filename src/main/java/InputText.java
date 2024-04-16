//Print 5 integers in a line
import java.util.Scanner;
import java.util.Arrays;

public class InputText {

    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 5 integers space seperated");
        String integerStr = scanner.nextLine();
        String[] temp = integerStr.split(" ");
        if(temp.length != 5){
            System.out.println("Error !! The input integer count !=5");
            return;
        }
        int i1= Integer.parseInt(temp[0]);
        int i2 = Integer.parseInt(temp[1]);
        int i3 = Integer.parseInt(temp[2]);
        int i4 = Integer.parseInt(temp[3]);
        int i5 = Integer.parseInt(temp[4]);

        //Alternate way is to store the integers in an array of size 5.
        int[] integerArray = new int[5];
        for(int x=0; x<5; x++) {
            integerArray[x] = Integer.parseInt(temp[x]);
        }
        System.out.println("Input array = " + Arrays.toString(integerArray));
    }
}