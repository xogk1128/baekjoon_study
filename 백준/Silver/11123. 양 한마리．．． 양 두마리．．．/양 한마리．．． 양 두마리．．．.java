import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int H;
    static int W;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static void check(){
        int cnt = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == '#' && !visited[i][j]){
                    dfs(j, i);
                    cnt++;
                }

            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= W || ny < 0 || ny >= H) continue;

            if(map[ny][nx] == '#' && !visited[ny][nx]){
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];

            for(int i=0; i<H; i++){
                String s = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = s.charAt(j);
                }
            }


            check();
        }
    }
}
