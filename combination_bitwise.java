import java.util.*;

public class combination_bitwise {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();

        for(int i = 1; i < (1 << n); i++) {

            for(int j = 0; j < n; j++) {

                if((i & (1 << j)) != 0) {
                    System.out.print(s.charAt(j));
                }
            }

            System.out.println();
        }
    }
}