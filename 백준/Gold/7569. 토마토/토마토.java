import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static int[][][] map;
    static int[] nx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] ny = new int[]{0, -1, 0, 1, 0, 0};
    static int[] nz = new int[]{0, 0, 0, 0, -1, 1};

    static int M;
    static int N;
    static int H;
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

    static int bfs(){

        while (!q.isEmpty()){
            Node node = q.poll();

            for (int i=0; i<6; i++){
                int dx = node.x + nx[i];
                int dy = node.y + ny[i];
                int dz = node.z + nz[i];

                if(dx >=0 && dx<M && dy >=0 && dy<N && dz >=0 && dz<H &&
                        map[dz][dy][dx] == 0){
                    q.offer(new Node(dx, dy, dz));
                    map[dz][dy][dx] = map[node.z][node.y][node.x] + 1;
                }
            }

        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){

                    if(map[i][j][k] == 0) return -1;
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return (result - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());

                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) q.offer(new Node(k, j, i));
                }
            }
        }

        System.out.println(bfs());
    }
}
