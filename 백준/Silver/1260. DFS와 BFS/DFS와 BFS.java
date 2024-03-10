import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] visitD;
    static boolean[] visitB;
    static int[][] map;

    static void dfs(int V){
        visitD[V] = true;
        System.out.print(V + " ");

        for(int i=1; i<=N; i++){
            if(map[V][i] == 1 && !visitD[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visitB[V] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");

            for (int i=1; i<=N; i++){
                if(map[node][i] == 1 && !visitB[i]) {
                    visitB[i] = true;
                    q.offer(i);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visitD = new boolean[N + 1];
        visitB = new boolean[N + 1];
        map = new int[N + 1][N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        dfs(V);
        System.out.println();
        bfs(V);

    }
}
