import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int A = Math.abs(o1);
                int B = Math.abs(o2);
                if(A>B){
                    return A-B;
                }
                else if(A == B){
                    if(o1>o2) return 1;
                    else return -1;
                }
                else {
                    return -1;
                }
            }
        });
        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                queue.add(num);
            }
            else{
                if(queue.isEmpty())
                    System.out.println(0);
                else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
