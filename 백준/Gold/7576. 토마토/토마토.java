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

    static int M;
    static int N;

    static int[][] map;
    static boolean[][] visited;

    static Queue<Node> q = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int cnt = -1;
    static int tomato = 0;
    public static void bfs(){

        while (!q.isEmpty()){
            int len = q.size();

            cnt++;
            for(int i=0; i<len; i++){
                Node node = q.poll();

                for(int j=0; j<4; j++){
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];

                    if(nx<0 || nx>=M || ny<0 || ny>=N) continue;

                    if (map[nx][ny] == 0 && !visited[nx][ny]){
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        tomato--;
                    }

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[j][i] = Integer.parseInt(st.nextToken());
                if(map[j][i] == 1) {
                    q.offer(new Node(j, i));
                    visited[j][i] = true;
                }else if(map[j][i] == 0)
                    tomato++;

            }
        }

        // map에 값을 넣으면서 토마토가 있었다면 bfs()
        if(tomato != 0){
            bfs();

            // bfs() 후 토마토가 0개 남았다면 모두 익었다.
            if(tomato == 0)
                System.out.println(cnt);
            else // 모두 익지 않음
                System.out.println(-1);
        }
        else // 토마토가 없다면 모두 익어있는 상태
            System.out.println(0);


    }
}
