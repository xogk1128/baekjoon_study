import java.util.Scanner;

public class Main {

	public static void sort(int[] list, int size) {
		int key;
		int j;
		for(int i=1; i<size; i++) {
			key = list[i];
			for(j=i-1; j>=0 && list[j]>key; j--)
				list[j+1] = list[j];
			list[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] list = new int[N];
		for(int i=0; i<N; i++) {
			list[i] = sc.nextInt();
		}
		sort(list, N);
		for(int num : list)
			System.out.println(num);
	}

}
