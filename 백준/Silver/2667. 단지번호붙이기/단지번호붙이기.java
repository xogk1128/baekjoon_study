import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static Queue<Node> q = new LinkedList<>();
    static int cnt = 1;
    static ArrayList<Integer> arr = new ArrayList<>();

    static void dfs(int x, int y){

        visited[y][x] = true;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx] == 1 && !visited[ny][nx]){
                dfs(nx, ny);
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 1){
                    q.offer(new Node(j, i));
                }
            }
        }

        while(!q.isEmpty()){
            cnt = 1;
            Node node = q.poll();
            if(!visited[node.y][node.x]){
                dfs(node.x, node.y);
                arr.add(cnt);
            }

        }

        Collections.sort(arr);

        System.out.println(arr.size());
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
