import java.util.Scanner;

public class Main {

	static boolean find(int num) {
		int hun = num/100;
		int ten = (num/10)%10;
		int one = num%10;
		if((hun-ten)==(ten-one))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 99;
		if(N<100)
			System.out.println(N);
		else {
			for(int i=100; i<=N; i++) {
				if(find(i))
					cnt++;
			}
			System.out.println(cnt);
		}

	}

}
