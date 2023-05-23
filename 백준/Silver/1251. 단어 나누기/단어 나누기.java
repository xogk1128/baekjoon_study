import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		int N = s.length();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=1; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				String res=new String();
				res+= reverse(0, i, s);
				res+= reverse(i, j, s);
				res+= reverse(j, N, s);
				arr.add(res);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(0));
	}
    
	static String reverse(int first, int last, String rev) {
		String s = new String();
		for(int i=last-1; i>=first; i--) {
			s += rev.charAt(i); 
		}
		return s;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}