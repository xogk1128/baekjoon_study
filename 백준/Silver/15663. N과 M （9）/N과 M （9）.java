import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] select;
    static int[] visited;
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
            if(i-1 >= 0 && arr[i] == arr[i-1]){
                continue;
            }


            if(visited[arr[i]] != 0){
                select[len] = arr[i];
                visited[arr[i]]--;
            }
            else continue;

            dfs(len+1);

            select[len] = 0;
            visited[arr[i]]++;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        select = new int[M];

        arr = new int[N];
        visited = new int[10001];


       for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            visited[arr[i]]++;
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);

    }


}


