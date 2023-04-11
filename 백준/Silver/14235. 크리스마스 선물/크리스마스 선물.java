import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while(n-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a==0){
                if(queue.size() == 0){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue.poll());
                }
            }
            else {

                for(int i=0; i<a; i++){
                    queue.add(Integer.parseInt(st.nextToken()));
                }
            }

        }
    }
}
