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
        int visitWall;

        public Node(int x, int y, int cnt, int visitWall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.visitWall = visitWall;
        }
    }
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Node> ans = new LinkedList<>();
    static int cnt;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][K+1];
        cnt = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = s.charAt(j-1) - '0';

            }
        }

        bfs();

        System.out.println(cnt);
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {

            Node node = q.poll();

            if(node.x == M && node.y == N){
                cnt = node.cnt;
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                if (nx <= 0 || nx > M || ny <= 0 || ny > N) continue;

                if (nx == M && ny == N && node.visitWall <= K) {
                    ans.offer(new Node(nx, ny, node.cnt + 1, node.visitWall));
                }


                if (map[ny][nx] == 1 && node.visitWall + 1 <= K && !visited[ny][nx][node.visitWall + 1]) {
                    q.offer(new Node(nx, ny, node.cnt + 1, node.visitWall + 1));
                    visited[ny][nx][node.visitWall + 1] = true;
                } else if (map[ny][nx] == 0 && !visited[ny][nx][node.visitWall]) {
                    q.offer(new Node(nx, ny, node.cnt + 1, node.visitWall));
                    visited[ny][nx][node.visitWall] = true;
                }

            }

        }
        cnt = -1;
    }

}
