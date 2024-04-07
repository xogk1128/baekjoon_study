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
    static int N;
    static int M;

    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int len = 0;
    static int cnt = 0;
    static boolean flag = true;

    public static int bfs() {
        Queue<Node> check = new LinkedList<>();
        boolean[][] checkVisited = new boolean[N][M];

        check.offer(new Node(0, 0));
        checkVisited[0][0] = true;

        while (!check.isEmpty()){
            Node node = check.poll();

            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                if(map[ny][nx] == 0 && !checkVisited[ny][nx]){
                    check.offer(new Node(nx, ny));
                    checkVisited[ny][nx] = true;
                }
                else if(map[ny][nx] == 1 && !checkVisited[ny][nx]){
                    map[ny][nx] = 0;
                    checkVisited[ny][nx] = true;
                }
            }


        }

        return checkCheese();
    }

    static int checkCheese(){
        int check = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(map[i][j] == 1){
                    check++;
                }
            }
        }

        return check;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int firstCnt = checkCheese();

        if(firstCnt == 0){
            System.out.println(0);
            System.out.println(0);
            return;
        }

        while (flag){
            len++;
            int cheeseCnt = bfs();

            if(cheeseCnt == 0){
                flag = false;
            }
            else{
                cnt = cheeseCnt;
            }

        }

        if(len <= 1){
            System.out.println(len);
            System.out.println(firstCnt);
        } else {
            System.out.println(len);
            System.out.println(cnt);
        }



    }
}
