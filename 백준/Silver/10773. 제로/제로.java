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
        else{
            int res = stack[top];
            stack[top--] = 0;
            return res;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        stack = new int[K];
        int num;
        for(int i=0; i<K; i++){
            num = Integer.parseInt(br.readLine());
            if(num == 0){
                pop();
            }
            else{
                push(num);
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
