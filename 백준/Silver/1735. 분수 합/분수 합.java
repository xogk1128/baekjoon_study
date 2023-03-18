import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 유클리드 호제법 이용
    static public int gcd(int A, int B){
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int X = x1 * y2 + x2 * y1;
        int Y = y1 * y2;
        // y1과 y2의 최대 공약수
        int r = gcd(X, Y);
        X/=r;
        Y/=r;

        System.out.println(X + " " + Y);


    }
}
