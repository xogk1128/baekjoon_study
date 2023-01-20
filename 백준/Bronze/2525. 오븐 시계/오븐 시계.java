import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int C = sc.nextInt();
		
		if(B+C >= 60) {
			if(A+(B+C)/60 >= 24)
				A = A + (B+C)/60 - 24;
			else
				A += (B+C)/60;
			B = (B + C)%60;
		}
		else
			B += C;
		
		System.out.println(A + " " + B);
		
		sc.close();
	}

}
