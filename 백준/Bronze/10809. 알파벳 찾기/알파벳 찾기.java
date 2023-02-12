import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int[] alpha = new int[26];
		for(int i=0; i<alpha.length; i++)
			alpha[i] = -1;
		
		for(int i=0; i<alpha.length; i++) {
			for(int j=0; j<S.length(); j++)
				if(alpha[S.charAt(j)-'a'] == -1)
					alpha[S.charAt(j)-'a'] = j;
			System.out.print(alpha[i] + " ");
		}
		
 	}

}
