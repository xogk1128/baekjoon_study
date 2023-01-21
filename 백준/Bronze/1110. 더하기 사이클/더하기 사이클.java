import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = 0, res = N;
		
		do {
			res = (res%10)*10 + (res/10 + res%10)%10;
			len++;
		}while(res!=N);
		System.out.println(len);
	}

}
