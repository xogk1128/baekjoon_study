import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for(int num : list)
			sb.append(num).append('\n');
		System.out.println(sb);

	}
}
