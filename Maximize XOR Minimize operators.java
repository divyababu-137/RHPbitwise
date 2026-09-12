import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long x = sc.nextLong();
            long y = sc.nextLong();

            long sum = x + y;

            long newX = 0;

             for (int bit = 28; bit >= 0; bit--) {

                long value = 1L << bit;

                if ((sum & value) != 0) {

                    if (newX + value <= x) {
                        newX += value;
                    }
                }
            }

            long operations = x - newX;

            System.out.println(sum + " " + operations);
        }

        sc.close();
    }
}