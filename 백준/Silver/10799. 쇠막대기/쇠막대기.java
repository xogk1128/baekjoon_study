import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' && str.charAt(i+1) == ')'){
                sum += stack.size();
                i++;
            }
            else if(str.charAt(i) == '('){
                stack.push('(');
            }
            else if(str.charAt(i) == ')') {
                sum ++;
                stack.pop();
            }

        }
        System.out.println(sum);
    }
}
