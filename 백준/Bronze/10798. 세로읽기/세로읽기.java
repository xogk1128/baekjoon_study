import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[5];
		String str = "";
		int max = 0;
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextLine();
			if(arr[i].length() > max)
				max = arr[i].length();
		}
		
		for(int i=0; i<max; i++)
			for(int j=0; j<5; j++) {
				if(arr[j].length() > i)
					str += arr[j].charAt(i);
			}
		System.out.println(str);
	}

}
