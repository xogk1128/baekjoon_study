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
        int wall;
        int cnt;

        public Node(int x, int y, int wall, int cnt) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }
    static int N;
    static int M;

    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1, 0, 1));
        visited[1][1][0] = true;

        while (!q.isEmpty()){
            Node node = q.poll();

            if(node.x == M && node.y == N)
                return node.cnt;

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx <= 0 || nx > M || ny <= 0 || ny > N) continue;

                if(map[ny][nx] == 1 && node.wall == 0 && !visited[ny][nx][node.wall + 1]){
                    visited[ny][nx][node.wall + 1] = true;
                    q.offer(new Node(nx, ny, node.wall + 1, node.cnt+1));
                }
                else if(map[ny][nx] == 0 && !visited[ny][nx][node.wall]){
                    visited[ny][nx][node.wall] = true;
                    q.offer(new Node(nx, ny, node.wall, node.cnt+1));

                }
            }
        }


        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }


        System.out.println(bfs());
    }
}
