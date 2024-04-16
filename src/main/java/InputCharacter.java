import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputCharacter{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a character  ");
        String str = scanner.nextLine();
        if (str.length() != 1) {
            System.out.println("Invalid character entered !");
            return;
        }
        char c = str.charAt(0);
        System.out.println("Entered character = " + c);


        System.out.println("Input a character  ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            c = (char) br.read();
            System.out.println("Entered character = " + c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}