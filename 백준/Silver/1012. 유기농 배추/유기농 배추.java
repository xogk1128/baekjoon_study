import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] adj;
    static boolean[][] visited;
    static int movX[] = {-1, 1, 0, 0};
    static int movY[] = {0, 0, 1, -1};
    static int M;
    static int N;
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(x,y));
        while(!Q.isEmpty()){
            Node node = Q.poll();

            for(int i=0; i<4; i++){
                int newX = node.x + movX[i];
                int newY = node.y + movY[i];

                if(newX >=0 && newX<M && newY >=0 && newY<N &&
                        adj[newX][newY] == 1 && !visited[newX][newY] ){
                    Q.offer(new Node(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            int count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            adj = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adj[start][end] = 1;
            }

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(adj[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        count ++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
