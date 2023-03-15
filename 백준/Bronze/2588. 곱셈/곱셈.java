import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int tmp = B;
        while(tmp >0){
            System.out.println(A*(tmp%10));
            tmp/=10;
        }
        System.out.println(A*B);
    }
}
