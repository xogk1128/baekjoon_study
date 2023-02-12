import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int N = sc.nextInt();
		sc.nextLine();
		String num = sc.nextLine();
		for(int i=0; i<N; i++)
			sum += num.charAt(i)-'0';
		System.out.println(sum);
	}

}
