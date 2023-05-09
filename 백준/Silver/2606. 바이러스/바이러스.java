import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> adj[];
    static Queue<Integer> Q = new LinkedList<>();
    static boolean[] visited;
    public static int bfs(int node){
        int cnt = 0;
        Q.offer(node);
        visited[node] = true;
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int j=0; j<adj[cur].size(); j++){
                int next = adj[cur].get(j);
                if(!visited[next]){
                    Q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }

        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++)
            adj[i] = new ArrayList<>();

        int edge = Integer.parseInt(br.readLine());
        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }


        System.out.println(bfs(1));
    }
}
