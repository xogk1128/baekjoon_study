import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		StringBuffer sb1 = new StringBuffer(A);
		StringBuffer sb2 = new StringBuffer(B);
		String reverse1 = sb1.reverse().toString();
		String reverse2 = sb2.reverse().toString();
		if(Integer.parseInt(reverse1) > Integer.parseInt(reverse2))
			System.out.print(reverse1);
		else
			System.out.print(reverse2);
	}

}
