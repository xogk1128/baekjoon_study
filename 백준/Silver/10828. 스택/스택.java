import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] stack;
    static int top = -1;
    static boolean isFull(){
        if(top == stack.length)
            return true;
        else
            return false;
    }

    static int isEmpty(){
        if(top == -1)
            return 1;
        else
            return 0;
    }

    static void push(int el){
        if(isFull())
            return;
        else
            stack[++top] = el;
    }

    static int pop(){
        if(isEmpty() == 1)
            return -1;
        else
            return stack[top--];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        stack = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                push(num);
            }
            else if(str.equals("pop")){
                System.out.println(pop());
            }
            else if(str.equals("size")){
                if(top == -1)
                    System.out.println("0");
                else
                    System.out.println(top+1);
            }
            else if(str.equals("top")){
                if(top == -1)
                    System.out.println("-1");
                else
                    System.out.println(stack[top]);
            }
            else
                System.out.println(isEmpty());
        }
    }
}
