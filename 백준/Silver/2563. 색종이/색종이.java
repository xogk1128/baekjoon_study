import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		int[][] arr = new int[101][101];
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=0;j<10;j++) {
				for(int k=0; k<10; k++) {
					arr[x+j][y+k] = 1;
				}
			}
		}
		for(int i=0; i<100; i++)
			for(int j=0; j<100; j++)
				sum += arr[i][j];
		
		System.out.println(sum);
	}

}
