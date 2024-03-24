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
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N;
    static int ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬마다 번호 부여
        int islandNum = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    dfs(j, i, islandNum);
                    islandNum++;
                }

            }
        }

        ans = Integer.MAX_VALUE;

        for(int i=1; i<=islandNum; i++){
            int[][] island = map.clone();
            bfs(island, i);
        }

        System.out.println(ans);
    }

    public static void bfs(int[][] island, int islandNum){
        boolean[][] checkSea = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if (map[i][j] == islandNum) {
                    q.offer(new Node(j, i, 0));
                    checkSea[i][j] = true;
                }

            }
        }

        while (!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Node node = q.poll();

                int nx, ny;
                for (int j = 0; j < 4; j++) {
                    nx = node.x + dx[j];
                    ny = node.y + dy[j];


                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (map[ny][nx] != islandNum && island[ny][nx] != 0) {
                        if(ans > node.cnt && node.cnt != 0)
                            ans = node.cnt;
                    }

                    if(island[ny][nx] == 0 && !checkSea[ny][nx]){
                        q.offer(new Node(nx, ny, node.cnt + 1));
                        checkSea[ny][nx] = true;
                    }


                }
            }
        }
    }

    public static void dfs(int x, int y, int islandNum){
        map[y][x] = islandNum;
        visited[y][x] = true;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];


            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] != 0 && !visited[ny][nx]) {
                dfs(nx, ny, islandNum);
            }
        }
    }
}
