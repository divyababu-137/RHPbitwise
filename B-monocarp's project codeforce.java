import java.util.*;
public class Main{
	static void solve(Scanner sc){
		long x = sc.nextLong();
		long y = sc.nextLong();
		long k = sc.nextLong();
		long rem =0, ctr =0, ans=0;
		while(ctr<k){
			rem = (y+ctr)%(x+ctr);
			if((y-x)==rem) break;
			ans+=rem;
			ctr++;
		}
		if(k>ctr){
			ans+=(y-x)*(k-ctr);
		}
		System.out.println(ans);
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
			solve(sc);
		}
		sc.close();
	}
}