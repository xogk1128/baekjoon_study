import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int b;
    static int[][] map;
    static boolean[] visited;
    static int count = 0;

    static void bfs(int a){
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);

        visited[a] = true;

        while (!q.isEmpty()){
            int len = q.size();
            for (int j=0; j<len; j++){
                int node = q.poll();
                if(node == b) return;

                for (int i=1; i<=n; i++){
                    if(map[node][i]==1 && !visited[i]){
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }

            count++;
            if(q.contains(b)){
                return;
            }
        }

        count = -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        bfs(a);
        System.out.println(count);
    }
}
