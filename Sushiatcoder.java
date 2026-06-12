import java.util.*;

public class Sushiatcoder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] A = new long[N];
        long[] B = new long[M];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        for(int i = 0; i < M; i++) {
            B[i] = sc.nextLong();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = N-1;
        int j = M-1;
        int count = 0;

        while(i >= 0 && j >= 0) {

            if(B[j] <= 2 * A[i]) {
                count++;
                i--;
                j--;
            }
            else {
                j--;
            }
        }

        System.out.println(count);
    }
}