import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int A, int B){
        if(B >= A){
            int tmp = A;
            A = B;
            B = tmp;
        }
        if(B==0) return A;
        else return gcd(B, A%B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S, ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int div = gcd(n,m);
        n /= div;
        m /= div;

        System.out.println(n +":" + m);

    }
}
