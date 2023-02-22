import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() + 1;
		int[] arr = new int[N];
		int M = sc.nextInt();
		
		int tmp;
		for(int i=1; i<N; i++)
			arr[i] = i;
		
		for(int i=0; i<M; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			tmp = arr[j];
			arr[j] = arr[k];
			arr[k] = tmp;
		}
		for(int i=1; i<N; i++)
			System.out.print(arr[i] + " ");
	}

}
