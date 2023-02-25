import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if(max < num[i])
				max = num[i];
		}
		int[] sorted = new int[N];
		int[] cnt = new int[max+1];
		
		for(int i=0; i<N; i++)
			++cnt[num[i]];
		for(int i=1; i<cnt.length; i++)
			cnt[i] += cnt[i-1];
		for(int i=0; i<N; i++)
			sorted[--cnt[num[i]]] = num[i];
		
		for(int val : sorted)
			bw.write(val + "\n");
		bw.flush();
		bw.close();
		
		
	}

}
