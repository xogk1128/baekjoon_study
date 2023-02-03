import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		float[] arr = new float[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		float sum = 0, M = arr[N-1];
		for(int i=0; i<N; i++) {
			arr[i] = (float)(arr[i]/M)*100;
			sum += arr[i];
		}
		System.out.println(sum/N);

	}

}
