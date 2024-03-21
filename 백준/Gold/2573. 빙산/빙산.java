import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static Queue<Node> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        while ((cnt = checkSeparate()) < 2){
            // 다 녹은 경우
            if(cnt == 0){
                ans = 0;
                break;
            }

            melt();
            ans++;
        }

        System.out.println(ans);
        br.close();
    }


    static void melt(){

        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(map[i][j] != 0){
                    q.offer(new Node(j, i));
                    visited[i][j] = true;
                }

            }
        }

        while (!q.isEmpty()) {

            Node node = q.poll();
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0 && !visited[ny][nx]) {
                    count++;
                }
            }

            if (map[node.y][node.x] - count < 0) {
                map[node.y][node.x] = 0;
            } else {
                map[node.y][node.x] -= count;
            }
        }
    }
    public static int checkSeparate() {

        visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(j, i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(int x, int y) {
        visited[y][x] = true;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];


            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] != 0 && !visited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }



}
