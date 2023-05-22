import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char key;
    static char map[][];
    static boolean visited[][];
    static int count = 0;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{-1,0,1,0};
    static char[] check = new char[]{'R', 'G', 'B'};

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if(!visited[ny][nx] && map[ny][nx]==key){
                dfs(ny, nx);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int k=0; k<3; k++){
            key = check[k];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == key  && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
        }

        System.out.print(count + " ");

        visited = new boolean[N][N];
        count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        for(int k=0; k<3; k+=2){
            key = check[k];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == key  && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
        }


        System.out.println(count);



    }
}
