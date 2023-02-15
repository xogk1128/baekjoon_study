import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] cro = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		for(int i=0; i<cro.length; i++) {
			while(str.contains(cro[i])) {
				cnt++;
				str = str.replaceFirst(cro[i], "/");
			}
		}
		str = str.replace("/", "");
		System.out.println((cnt+str.length()));
	}

}
