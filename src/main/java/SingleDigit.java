//Multi digit to single digit

public class SingleDigit {

    public static void main(String[] args) {
        int input = 145;
        while(input >= 10) {
            input = convert(input);
        }
        System.out.println(input);

    }

    public static int convert(int input) {
        if(input < 10) {
            return input;
        }

        return (input % 10) + convert(input/10);
    }
}