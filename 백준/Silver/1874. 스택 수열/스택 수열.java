import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            int input = Integer.parseInt(br.readLine());
            for(;num<=input; num++){
                stack.push(num);
                sb.append("+\n");
            }
            if(stack.peek() == input){
                stack.pop();
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
