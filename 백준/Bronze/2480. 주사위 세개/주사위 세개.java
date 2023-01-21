import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int score = 0;
		if(A==B && B==C)
			score = 10000 + A*1000;
		else if((A==B && B!=C) || (B==C && B!=A || (A==C && C!=B))) {
			score += 1000;
			if(A==B) score += A*100;
			else if(B==C) score += B*100;
			else if(C==A) score += C*100;
		}else {
			if(A>B && A>C)score=A*100;
			else if(B>A && B>C) score=B*100;
			else if(C>A && C>B)score=C*100;
		}
		
		System.out.println(score);
	}

}
