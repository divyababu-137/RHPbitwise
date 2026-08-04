import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		String s = sc.next();
		int pos = n-1;
		while(q-- > 0){
			int qt = sc.nextInt();
			int x = sc.nextInt();
			x=x%n;
			if(qt==1){
				pos=pos-x;
				if(pos<0){
					pos+=n;
				}
			}else{
				System.out.println(s.charAt((pos + x) % n));
			}
			
		}
	}
}