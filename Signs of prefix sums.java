import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            String s = sc.next();

            int[] a = new int[n];

            int previous = 0;
            int answer = 0;

            boolean possible = true;

            for (int i = 0; i < n; i++) {

                char ch = s.charAt(i);

                int current;

                if (ch == '+') {
                    current = 1;
                } 
                else if (ch == '-') {
                    current = -1;
                } 
                else {
                    current = 0;
                }

                a[i] = current - previous;

                if (a[i] == 0) {
                    possible = false;
                }

                answer = Math.max(answer, Math.abs(a[i]));

                previous = current;
            }

            if (!possible) {
                System.out.println(-1);
            } 
            else {
                System.out.println(answer);
            }
        }

        sc.close();
    }
}