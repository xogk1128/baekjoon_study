import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    static int cnt = 0;
    static ArrayList<Point> arr = new ArrayList<>();
    static void hanoi(int n, int from, int tmp, int to){
        cnt++;
        if (n == 1)
            arr.add(new Point(from, to));
        else {
            // 1 ~ n-1 을 임시 장소에 이동
            hanoi(n - 1, from, to, tmp);
            // 제일 밑에 있는 원판을 이동
            arr.add(new Point(from, to));
            // 1 ~ n-1 을 임시 장소에서 목적지로 이동
            hanoi(n - 1, tmp, from, to);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        bw.write(cnt + "\n");
        for (Point point : arr) {
            bw.write(point.x + " " + point.y + "\n");
        }
        bw.flush();
        bw.close();
    }
}
