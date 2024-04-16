import java.util.Map;
import java.util.Stack;

public class InToPostFix {

    static Map<Character, Integer> operatorMap = Map.of('+',1,
            '-', 1,
            '*', 2,
            '/',2,
            '(',10,
            ')',10,
            '^', 4);

    public static void main(String[] args) {
        String inFix = "A+B*C+D";
        System.out.println(convert(inFix));

        inFix = "((A+B)-C*(D/E))+F";
        System.out.println(convert(inFix));

        //AB+CDE/*-F+
    }

    public static String convert(String inFix) {
        Stack<Character> operators = new Stack<>();

        StringBuilder postFix = new StringBuilder();
        for (int i = 0; i < inFix.length(); i++) {
            char current = inFix.charAt(i);
            if (operatorMap.containsKey(current)) {
                if (!operators.isEmpty()) {
                    char previous = operators.peek();
                    if (previous != '(') {
                        if (previous == ')') {
                            while (previous != '(' && !operators.isEmpty()) {
                                previous = operators.pop();
                                if (previous != ')' && previous != '(') {
                                    postFix.append(previous);
                                }
                            }
                        } else if (operatorMap.get(previous) > operatorMap.get(current)) {
                            while (!operators.isEmpty()) {
                                previous = operators.pop();
                                if (previous != ')' && previous != '(') {
                                    postFix.append(previous);
                                }
                            }
                        }
                    }
                }
                operators.push(current);
            } else {
                postFix.append(current);
            }
        }

        while (!operators.isEmpty()) {
            postFix.append(operators.pop());
        }
        return postFix.toString();
    }

}
