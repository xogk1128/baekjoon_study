import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int piv(int num){
        int f1, f2, f3;
        if(num == 0)
            return 0;
        else if (num < 2)
            return 1;
        else {
            f3 = piv(num-1) + piv(num-2);
            return f3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(piv(N));
    }
}
