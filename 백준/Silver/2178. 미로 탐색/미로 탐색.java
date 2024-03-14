import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;

    static int[] moveX = new int[]{-1, 0, 1, 0};
    static int[] moveY = new int[]{0, -1, 0, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));


        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + moveX[i];
                int ny = node.y + moveY[i];

                if(nx > 0 && ny > 0 && nx <= M && ny <= N &&
                        map[ny][nx] == 1 && !visited[ny][nx]){
                    q.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                    map[ny][nx] = map[node.y][node.x] + 1;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            String maze = br.readLine();
            for (int j=1; j<=M; j++){
                map[i][j] = maze.charAt(j-1) - '0';
            }
        }


        bfs(1, 1);

        System.out.println(map[N][M]);

    }
}
