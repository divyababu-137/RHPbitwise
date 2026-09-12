import java.util.*;

public class Main {

    static void solve(Scanner sc) {

        
        int n = sc.nextInt();
        int[] cm = new int[26];
        Arrays.fill(cm,50);
        for(int ctr = 1; ctr <=n;ctr++){
        	String s = sc.next();
        	int[] curr = new int[26];
        	for(int j=0;j<s.length();j++){
        		char ch = s.charAt(j);
        		curr[ch-'a']++;
        	}
        	for(int i=0;i<26;i++){
        		cm[i]=Math.min(cm[i],curr[i]);
        	}
        }
        for(int i=0;i<26;i++){
        	while(cm[i]-->0){
        		System.out.print((char) ('a'+i));
        	}
        }
        System.out.println();
    }
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	solve(sc);
    }
}