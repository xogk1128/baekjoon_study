import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> check = new Stack<>();
        Deque<String> deque = new ArrayDeque<>();

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int btn = Integer.parseInt(st.nextToken());
            String ch;

            if(btn == 1){
                ch = st.nextToken();
                deque.addLast(ch);
                check.add(btn);
            }
            else if(btn == 2){
                ch = st.nextToken();
                deque.addFirst(ch);
                check.add(btn);
            }
            else {
                if(!check.isEmpty()){
                    if(check.peek() == 1){
                        deque.removeLast();
                        check.pop();
                    }
                    else if(check.peek() == 2){
                        deque.removeFirst();
                        check.pop();
                    }
                }

            }
        }


        if(deque.size() == 0)
            System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
