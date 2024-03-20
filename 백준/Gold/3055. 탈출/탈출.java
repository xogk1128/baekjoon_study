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
    static int R;
    static int C;
    static char[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static boolean[][] visitedW;
    static int count = 0;

    static Queue<Node> water = new LinkedList<>();
    static Node start;
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty() || !water.isEmpty()){
            count++;
            // 물의 이동
            int lenW = water.size();

            for(int i=0; i<lenW; i++){
                Node nowWater = water.poll();
                visitedW[nowWater.y][nowWater.x] = true;

                for(int j=0; j<4; j++){
                    int nxW = dx[j] + nowWater.x;
                    int nyW = dy[j] + nowWater.y;

                    if(nxW >= 0 && nxW < C && nyW >= 0 && nyW < R
                            && ( map[nyW][nxW] == '.' || map[nyW][nxW] == 'S' ) && !visitedW[nyW][nxW]){

                        water.offer(new Node(nxW, nyW));
                        visitedW[nyW][nxW] = true;
                        map[nyW][nxW] = '*';
                    }
                }
            }

            // 고슴도치의 이동

            int lenS = q.size();
            for(int i=0; i<lenS; i++){
                Node node = q.poll();
                visitedW[node.y][node.x] = true;

                for(int j=0; j<4; j++) {
                    int nxS = dx[j] + node.x;
                    int nyS = dy[j] + node.y;

                    if(nxS >= 0 && nxS < C && nyS >= 0 && nyS < R
                            && ( map[nyS][nxS] == '.' || map[nyS][nxS] == 'D' ) && !visitedW[nyS][nxS] ){

                        if(map[nyS][nxS] == 'D'){
                            return;
                        }

                        q.offer(new Node(nxS, nyS));
                        visitedW[nyS][nxS] = true;
                    }
                }
            }
        }
        count = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visitedW = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'S')
                    start = new Node(j, i);
                else if(map[i][j] == '*')
                    water.offer(new Node(j, i));
            }
        }

        bfs();

        if(count == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(count);
    }
}
