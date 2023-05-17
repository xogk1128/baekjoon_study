import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] graph;
    static boolean visited[];
    static int count = 0;
    static void bfs(int n){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        visited[n] = true;
        while(!Q.isEmpty()){
            int node = Q.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && graph[node][i]) {
                    visited[i] = true;
                    Q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }

        }
        System.out.println(count);
    }
}
