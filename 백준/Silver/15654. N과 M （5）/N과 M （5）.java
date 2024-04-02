import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
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

        for(int i=0; i<N; i++){
            if(!visited[i]){
                select[len] = arr[i];
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

        st = new StringTokenizer(br.readLine());

        select = new int[M];
        visited = new boolean[N+1];
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);

    }


}
