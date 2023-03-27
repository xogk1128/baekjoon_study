import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 첫번째 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두번째 입력 = 숫자 입력받기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int[] sum = new int[N+1];
        for(int i=1; i<N+1; i++)
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());


        int i, j;
        for(int k=0; k<M; k++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            sb.append(sum[j]-sum[i-1] + "\n");
        }
        System.out.println(sb);
    }
}
