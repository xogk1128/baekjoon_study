import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int cnt = 0;
    // 북, 동, 남, 서 방향 순서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void clean(int x, int y, int d) {
        // 현재 위치를 청소한다.
        if (map[x][y] == 0) {
            map[x][y] = 2; // 청소한 곳은 2로 표시
            cnt++;
        }

        // 현재 방향을 기준으로 왼쪽 방향부터 탐색
        for (int i = 0; i < 4; i++) {
            // 왼쪽 방향으로 회전
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 아직 청소하지 않은 곳이라면 청소한다.
            if (map[nx][ny] == 0) {
                clean(nx, ny, d);
                return;
            }
        }

        // 네 방향 모두 청소가 이미 되어있거나 벽인 경우
        // 후진하고 다시 청소 과정을 반복한다.
        int backX = x - dx[d];
        int backY = y - dy[d];
        if (map[backX][backY] != 1) {
            clean(backX, backY, d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 로봇 청소기가 청소하는 과정 시작
        clean(r, c, d);

        System.out.println(cnt);
    }
}
