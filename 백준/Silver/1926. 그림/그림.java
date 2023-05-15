import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int max, width = 0;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{-1,0,1,0};

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if(!visited[ny][nx] && map[ny][nx]==1){
                dfs(ny, nx);
                width++;
            }
        }
        max = Math.max(max, width+1);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j]==1){
                    width = 0;
                    dfs(i, j);

                    count++;
                }

            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
