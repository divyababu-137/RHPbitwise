import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        for(int k=0;k<n;k++){
            String s1 = sc.next();
            String s2 = sc.next();
            int r= s1.length();
            int c=s2.length();
            int[] x = new int[r];
            int[] y = new int[c];
            x[k] = s1.charAt(0) - '0';
            y[k] = s2.charAt(0) - '0';
            for(int i=1;i<r;i++){
                x[i] = (x[i-1]+(s1.charAt(i)-'0'))%10;
            }
            for(int j=1;j<c;j++){
                y[j] = (y[j-1]+(s2.charAt(j)-'0'))%10;
            }
            if(x[r-1] != y[c-1]){
                System.out.println(-1);
              
            }
            int[][] dp = new int[r+1][c+1];
            for(int row =1; row<=r; row++){
                for(int col=1;col<=c;col++){
                    if(x[row-1]==y[col-1]){
                        dp[row][col] = dp[row-1][col-1]+1;
                    }else{
                        dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                    }  
                }
            }
            System.out.println(dp[r][c]);
        }
    }
}