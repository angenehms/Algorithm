

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;

    static int[] arr;
    static int shortest = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sectionSum = 0; // 구간합

        for (int right = 0; right < N; right++) {

            sectionSum += arr[right];

            if (sectionSum < S) continue;

            if (shortest > getSectionLength(left, right)) {
                shortest = getSectionLength(left, right);
            }

            while (left < right) {
                sectionSum -= arr[left];
                left++;

                if (sectionSum >= S) {
                    shortest = Math.min(shortest, getSectionLength(left, right));
                } else {
                    break;
                }
            }
        }

        System.out.println(shortest == Integer.MAX_VALUE ? 0 : shortest);
    }

    static int getSectionLength(int left, int right) {
        return right - left + 1;
    }
}
