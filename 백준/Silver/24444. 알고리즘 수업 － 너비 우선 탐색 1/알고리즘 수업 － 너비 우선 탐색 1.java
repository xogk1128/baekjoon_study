import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] count;

    static int N;

    static void bfs(int R){
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        visited[R] = true;
        count[R] = cnt++;

        while (!q.isEmpty()){
            int node = q.poll();

            for(int i : list.get(node)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count[i] = cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        count = new int[N+1];

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        for(int i=1; i<=N; i++){
            ArrayList<Integer> pos = list.get(i);
            Collections.sort(pos);
        }

        bfs(R);
        for (int i=1; i<=N; i++){
            System.out.println(count[i]);
        }
    }
}
