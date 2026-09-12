import java.util.*;
public class Main{
	static void solve(Scanner sc){
		int N = sc.nextInt();
		int[] arr = new int[N];
		int oc = 0;
		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
			oc += arr[i];
			
		}
		int zc = N-oc;
		int ans = 0;
		if(zc<2){
			System.out.println(-1);
			return;
		}
		if(arr[0]==1){
			ans++;
		}
		if(arr[N-1]==1){
			ans++;
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