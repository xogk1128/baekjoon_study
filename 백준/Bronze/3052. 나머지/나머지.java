import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			arr[num%42] = 1;
		}
		int cnt = 0;
		for(int i=0; i<42; i++) {
			if(arr[i]==1)
				cnt++;
		}
		System.out.println(cnt);

	}

}
