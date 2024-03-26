import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static final int MAX = (int)1e9;

    static int[] coins;
    static int[] dp;

    public static int recursive(int cur){
        // k 동전을 만들 수 없는 경우
        if(cur < 0) return 1000000;

        if(dp[cur] != MAX) return dp[cur];

        // base case
        if(cur == 0) return 0;

        int min = 1000_000;
        for(int i=0; i<n; i++){
            int ret = recursive(cur - coins[i]) +1;
            min = Math.min(min, ret);
        }

        return dp[cur] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k+1];

        Arrays.fill(dp, MAX);

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ret = recursive(k);

        if(ret == 1000_000)
            System.out.println(-1);
        else
            System.out.println(ret);
    }
}
