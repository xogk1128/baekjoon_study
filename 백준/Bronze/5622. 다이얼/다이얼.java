import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int time = 0;
		// 문자 / 3 = 값 + 3 => 초
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>= 'A' && str.charAt(i)<= 'O')
				time += ((int)str.charAt(i)-'A')/3 + 3;
			else if(str.charAt(i)>= 'P' && str.charAt(i)<= 'S')
				time += 8;
			else if(str.charAt(i)>= 'T' && str.charAt(i)<= 'V')
				time += 9;
			else 
				time += 10;
		}
		System.out.println(time);
	}

}
