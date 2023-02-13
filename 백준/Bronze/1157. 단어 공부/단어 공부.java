import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] alpha = new int[26];
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				alpha[str.charAt(i)-'A']++;
			else
				alpha[str.charAt(i)-'a']++;
		}
		
		int max=0;
		char ch = '?';
		for(int i=0; i<alpha.length; i++) {
			if(max !=0 && max == alpha[i])
				ch = '?';
			else if(alpha[i] > max) {
				max = alpha[i];
				ch = (char)(i + 'A');
			}
		}
		System.out.println(ch);

	}

}
