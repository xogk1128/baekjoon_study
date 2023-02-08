
public class Main {
	static boolean check(int num) {
		for(int i=1; i<num; i++) {
			int sum = 0;
			int tmp = i;
			while(tmp>0) {
				sum += tmp%10;
				tmp/= 10;
			}
			if(i+sum == num) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int i=1; i<=10000; i++) {
			if(check(i))
				System.out.println(i);			
		}

	}

}
