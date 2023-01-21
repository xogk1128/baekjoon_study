import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			String array[] = s.split(" ");
			
			bw.write(Integer.parseInt(array[0])+Integer.parseInt(array[1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}
