import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;
    public static void dfs(int x, int y, int k){
        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx <0 || nx >= N || ny < 0 || ny >= N) continue;
            if(map[ny][nx] > k  &&!visited[ny][nx]){
                dfs(nx, ny, k);

            }


        }
    }

    public static void start(){
        for(int k=0; k<=max; k++){
            int count = 0;
            visited = new boolean[N][N];
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(map[i][j] > k  && !visited[i][j]) {
                        dfs(j, i, k);
                        count++;
                    }

                }
            }
            cnt = Math.max(count, cnt);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        start();
        System.out.println(cnt);
    }
}
