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
        int who;

        public Node(int x, int y, int who) {
            this.x = x;
            this.y = y;
            this.who = who;
        }
    }

    static int R;
    static int C;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] check;
    static int cnt = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> q = new LinkedList<>();

    public static void bfs(){

        while (!q.isEmpty()){

            int len = q.size();

            for(int i=0; i<len; i++){
                Node node = q.poll();


                for(int j=0; j<4;j++) {
                    int nx = dx[j] + node.x;
                    int ny = dy[j] + node.y;

                    if (nx <= 0 || nx > C || ny <= 0 || ny > R) continue;

                    if(map[ny][nx] == 0 && !visited[ny][nx][node.who]){
                        q.offer(new Node(nx, ny, node.who));
                        visited[ny][nx][node.who] = true;
                        check[ny][nx]++;
                    }
                }

            }

            cnt++;
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(check[i][j] == 3){
                        System.out.println(cnt);
                        return;
                    }
                }
            }

        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        visited = new boolean[R+1][C+1][3];
        check = new int[R+1][C+1];

        for(int i=1; i<=R; i++){
            String s = br.readLine();
            for(int j=1; j<=C; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q.offer(new Node(b, a, i));
            visited[a][b][i] = true;
            check[a][b]++;
        }


        bfs();

        int total = 0;
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(check[i][j] == 3){
                    total++;
                }
            }
        }

        if(total != 0)
            System.out.println(total);
    }
}
