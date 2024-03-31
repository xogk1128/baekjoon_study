import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static char[][] map;
    static int[] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int x, int y){
        visited[map[y][x]] = 1;
        cnt++;

        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            if(visited[map[ny][nx]] != 1){

                dfs(nx, ny);
                cnt--;

            }
        }
        max = Math.max(max, cnt);
        visited[map[y][x]] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new int['Z' + 1];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(max);

    }
}
