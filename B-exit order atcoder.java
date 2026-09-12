import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int st = 0;
		int end =10;
		for(int i=1;i<n;i++){
			int curr = sc.nextInt();
			if(!(curr>=st && curr<=end)){
				System.out.println("NO");
				return;
			}
			if(i%10==0){
				st+=10;
				end+=10;
			}
		}
		System.out.println("YES");
	}
}