import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){

            if(S.charAt(i) == '<'){
                while(stack.size()!=0) {
                    sb.append(stack.pop());
                }
                while(S.charAt(i) != '>'){
                    sb.append(S.charAt(i));
                    i++;
                }
                sb.append(">");
            }
            else if(S.charAt(i) == ' '){
                if(stack.size()>=1){
                    while(stack.size()!=0){
                        sb.append(stack.pop());
                    }
                }
                sb.append(" ");
            }
            else{
                stack.push(S.charAt(i));
            }

        }
        while(stack.size()!=0){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
