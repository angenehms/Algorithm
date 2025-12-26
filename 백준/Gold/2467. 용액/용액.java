import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] liq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        liq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int bestSum = Integer.MAX_VALUE;
        int ansL = 0;
        int ansR = N - 1;

        while (left < right) {

            int sum = liq[left] + liq[right];

            if (Math.abs(sum) < bestSum) {
                bestSum = Math.abs(sum);
                ansL = left;
                ansR = right;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(liq[ansL] + " " + liq[ansR]);
    }
}