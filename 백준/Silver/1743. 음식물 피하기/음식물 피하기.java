import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] adj;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int max, width = 0;
    static int M;
    static int N;
    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;
            if(!visited[ny][nx] && adj[ny][nx]==1){
                dfs(ny, nx);
                width++;
            }
        }
        max = Math.max(max, width+1);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        adj = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start-1][end-1] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(adj[i][j] == 1 && !visited[i][j]){
                    width = 0;
                    dfs(i, j);
                }
            }
        }

        System.out.println(max);
    }
}
