import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            boolean flag = false;
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '(')
                    stack.push(s.charAt(j));
                else if(s.charAt(j) == ')')
                    if(stack.empty()){
                        flag = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
            }
            if(!stack.empty() || flag)
                System.out.println("NO");
            else System.out.println("YES");
            stack.clear();
        }

    }
}
