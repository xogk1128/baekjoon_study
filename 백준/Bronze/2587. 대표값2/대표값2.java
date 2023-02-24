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
		int[] list = new int[5];
		int res = 0;
		for(int i=0; i<5; i++)
			list[i] = sc.nextInt();
		sort(list, 5);
		for(int num : list)
			res += num;
		res /= 5;
		System.out.println(res);
		System.out.println(list[2]);
	}

}
