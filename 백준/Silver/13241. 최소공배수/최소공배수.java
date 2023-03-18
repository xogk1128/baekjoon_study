import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 유클리드 호제법 이용
    static public long gcd(long A, long B){
        if(B==0) return A;
        else return gcd(B, A%B);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long r = gcd(A, B);
        System.out.println(A*B / r);

    }
}
