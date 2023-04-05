import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Stack<Character> stack = new Stack<>();
        int caseNum = 1;
        while(true){
            int cnt = 0;
            stack.clear();
            s = br.readLine();
            if(s.charAt(0) == '-')
                break;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '}'){
                    if(stack.empty()){
                        stack.push('{');
                        cnt++;
                    }
                    else{
                        stack.pop();
                    }
                }
                else if(s.charAt(i) == '{'){
                    stack.push('{');
                }
            }
            System.out.println(caseNum + ". " + (cnt+(stack.size())/2));



            caseNum++;
        }
    }
}
