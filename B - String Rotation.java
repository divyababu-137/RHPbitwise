import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		String s = sc.next();
		String t = sc.next();
		String dt = t+t;
		System.out.println(dt.contains(s)?"yes":"no") ;
	}
}