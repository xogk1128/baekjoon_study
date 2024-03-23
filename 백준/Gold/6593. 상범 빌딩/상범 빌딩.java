import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int L;
    static int R;
    static int C;
    static char[][][] map;
    static boolean[][][] visited;
    static Queue<Node> q = new LinkedList<>();

    static int count;

    static int[] nx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] ny = new int[]{0, -1, 0, 1, 0, 0};
    static int[] nz = new int[]{0, 0, 0, 0, -1, 1};

    static void bfs(){

        count = 0;
        while (!q.isEmpty()){
            int len = q.size();
            count++;
            for(int j=0; j<len; j++) {
                Node node = q.poll();

                for (int i = 0; i < 6; i++) {
                    int dx = node.x + nx[i];
                    int dy = node.y + ny[i];
                    int dz = node.z + nz[i];

                    if (dx >= 0 && dx < C && dy >= 0 && dy < R && dz >= 0 && dz < L &&
                            (map[dz][dy][dx] == '.' || map[dz][dy][dx] == 'E') && !visited[dz][dy][dx]) {
                        if(map[dz][dy][dx] == 'E')
                            return;
                        q.offer(new Node(dx, dy, dz));
                        visited[dz][dy][dx] = true;
                    }
                }
            }

        }
        count = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0)
                break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            q = new LinkedList<>();

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String s = br.readLine();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = s.charAt(k);
                        if(map[i][j][k] == 'S') {
                            q.offer(new Node(k, j, i));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            bfs();

            if(count == 0){
                System.out.println("Trapped!");
            }
            else {
                System.out.println("Escaped in " + count + " minute(s).");
            }
        }


    }
}
