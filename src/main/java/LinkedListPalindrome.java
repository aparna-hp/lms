import java.util.LinkedList;
import java.util.List;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 2, 1));
        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(LinkedList<Integer> list) {
        return true;
    }
}
