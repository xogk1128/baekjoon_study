import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] select;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;

    static void dfs(int len){

        if(len == M) {
            for (Integer integer : select) {
                sb.append(integer + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i] && ((len >= 1 && i > select[len-1]) || len == 0)){

                select[len] = i;
                visited[i] = true;


            }
            else continue;

            dfs(len+1);
            select[len] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        visited = new boolean[N+1];

        dfs(0);
        System.out.println(sb);

    }

}
