import java.util.*;

public class LongestIncreasingPath {

    static int[][] dp;

    static int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    static int dfs(int[][] matrix,int r,int c){

        if(dp[r][c] != 0)
            return dp[r][c];

        int maxLen = 1;

        for(int[] d : dir){

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr>=0 && nr<matrix.length &&
               nc>=0 && nc<matrix[0].length &&
               matrix[nr][nc] > matrix[r][c]){

                maxLen = Math.max(maxLen,
                                  1 + dfs(matrix,nr,nc));
            }
        }

        dp[r][c] = maxLen;

        return maxLen;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        dp = new int[rows][cols];

        int ans = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans = Math.max(ans, dfs(matrix,i,j));
            }
        }

        System.out.println(ans);
    }
}