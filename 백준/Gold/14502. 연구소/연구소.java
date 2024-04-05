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
    static int max;
    static Queue<Node> q = new LinkedList<>();


    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);


    }

    static void dfs(int cnt){

        if(cnt == 3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new Node(j, i));
                }
            }
        }

        int[][] cloneMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }

        while (!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (cloneMap[ny][nx] == 0) {
                    q.offer(new Node(nx, ny));
                    cloneMap[ny][nx] = 2;
                }
            }
        }

        checkSafe(cloneMap);
    }

    static void checkSafe(int[][] cloneMap){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(cloneMap[i][j] == 0)
                    cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}
