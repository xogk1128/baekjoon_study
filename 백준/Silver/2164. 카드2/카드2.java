import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        while(q.size() > 1) {	// 원소가 한 개만 남을 때 까지
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());	// 마지막으로 남은 원소 출력
    }
}
