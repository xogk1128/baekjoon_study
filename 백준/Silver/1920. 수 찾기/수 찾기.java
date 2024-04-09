import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(nums, 0, nums.length - 1, num));
        }
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {

        while (start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return 1;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return 0;
    }
}
