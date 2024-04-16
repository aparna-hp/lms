public class BinaryGame {

    public static void main(String[] args) {
        int N = 6;
        String S = "010111";
        String T = "";

        int startIndex = 0;
        int endIndex = N -1;
        while(startIndex <= endIndex) {
            T = BinaryGame.play(S, T, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
        System.out.println("T string " + T);

    }

    public static String play(String S, String T, int startIndex, int endIndex) {
        char startChar = S.charAt(startIndex);
        char endChar = S.charAt(endIndex);

        if(startChar < endChar) {
            //StartChar = 0, endChar =1
            //Alice plays
            T = "0" + T;

            //Bob plays
            T = "1" + T;
        } else {
            if(startChar == '0') {
                //startChar = 0, endChar =0
                //Alice plays
                T = "0" + T;

                //Bob plays
                T = T = "0";
            } else {
                //startChar =1, endChar =0/1
                //Alice plays
                T = T + "1";

                //Bob plays
                if(endChar == '0') {
                    T = T + "0";
                } else {
                    T = "1" + T;
                }
            }
        }
        return T;
    }
}