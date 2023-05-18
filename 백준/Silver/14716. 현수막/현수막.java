import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int map[][];
    static boolean visited[][];
    static int count = 0;
    static int[] dx = new int[]{0,1,0,-1,-1,1,1, -1};
    static int[] dy = new int[]{-1,0,1,0,-1,-1,1,1};

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= w || ny < 0 || ny >= h)
                continue;
            if(!visited[ny][nx] && map[ny][nx]==1){
                dfs(ny, nx);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        count = 0;
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);



    }
}
