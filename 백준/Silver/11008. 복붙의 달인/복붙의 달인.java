import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String s = st.nextToken();

            p = p.replaceAll(s, ",");
            System.out.println(p.length());
        }
    }
}
