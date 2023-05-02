import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            s += s;
            if(s.contains(word))
                cnt++;
        }
        System.out.println(cnt);
    }
}
