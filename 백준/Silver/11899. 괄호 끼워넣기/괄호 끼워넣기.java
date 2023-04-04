import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ')' && !stack.empty()){
                stack.pop();
            }
            else if(str.charAt(i) == '('){
                stack.push('(');
            }
            else{
                cnt++;
            }
        }
        cnt += stack.size();
        System.out.println(cnt);

    }
}
