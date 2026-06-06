import java.util.*;

public class Dpcol {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int grid[][] = new int[R][C];
        long dp[][] = new long[R][C];

        // Input
        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {

                grid[row][col] = sc.nextInt();

                // First column
                if(col == 0) {
                    dp[row][col] = grid[row][col];
                }
            }
        }

        // DP
        for(int col = 1; col < C; col++) {

            long fsmax[] = getFSMAX(dp, R, col - 1);

            for(int row = 0; row < R; row++) {

                dp[row][col] =
                    grid[row][col]
                    + (dp[row][col - 1] == fsmax[0]
                    ? fsmax[1]
                    : fsmax[0]);
            }
        }

        System.out.println(getFSMAX(dp, R, C - 1)[0]);
    }

    private static long[] getFSMAX(long[][] dp, int R, int col) {

        long fmax = Math.max(dp[0][col], dp[1][col]);
        long smax = Math.min(dp[0][col], dp[1][col]);

        for(int row = 2; row < R; row++) {

            if(dp[row][col] > fmax) {
                smax = fmax;
                fmax = dp[row][col];
            }
            else if(dp[row][col] > smax) {
                smax = dp[row][col];
            }
        }

        return new long[]{fmax, smax};
    }
}