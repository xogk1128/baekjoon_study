import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
    static int[][] map;
    static int[][] visited;
    static int cnt = Integer.MAX_VALUE;
    static int wallCnt = 0;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void bfs(){
        q.offer(new Node(0, 0));
        visited[0][0] = 0;

        while (!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(visited[ny][nx] > visited[node.y][node.x]){
                    if(map[ny][nx] == 1){
                        visited[ny][nx] = visited[node.y][node.x];

                    }
                    else if(map[ny][nx] == 0){
                        visited[ny][nx] = visited[node.y][node.x] + 1;

                    }

                    q.offer(new Node(nx, ny));
                }


            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];

        wallCnt = 0;
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(visited[N-1][N-1]);
    }
}
