import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(queue.isEmpty()){
                    sb.append(0 + "\n");
                }
                else {
                    sb.append(queue.poll() + "\n");
                }
            }
            else {
                queue.add(x);
            }
        }
        System.out.println(sb);
    }
}
