import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		for(int i=0; i<P; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			String res = "";
			for(int j=0;j<S.length();j++) {
				for(int k=0; k<R; k++)
					res += S.charAt(j);
			}
			System.out.println(res);
		}

	}

}
