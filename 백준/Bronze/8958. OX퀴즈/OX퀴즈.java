import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.next();
		}
		for(int i=0; i<N; i++) {
			int sum = 0, score = 1;
			for(int j=0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') {
					sum+= score;
					score++;
				}
				else
					score = 1;
			}
			System.out.println(sum);
		}
		
	}

}
