import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int i=0; i<C; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			float sum = 0;
			float cnt = 0;
			for(int j=0; j<N; j++) {
				sum += arr[j] = sc.nextInt();
			}
			sum /= N;
			for(int j=0; j<N; j++) {
				if(arr[j] > sum)
					cnt++;
			}
			cnt = cnt/N*100;
			System.out.println(String.format("%,.3f", cnt)+"%");
		}
		
	}
}
