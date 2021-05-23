import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_11060_점프점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];
        int arr[] = new int[n + 1];
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        Arrays.fill(dp, 123456789);
        if (arr[1] != 0)
            dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] != 123456789) {
                int jump = arr[i];
                for (int j = 1; j <= jump; j++) {
                    if (i + j > n) continue;
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
        if (n == 1) {
            System.out.println(0);
        } else {
            System.out.println(dp[n] == 123456789 ? -1 : dp[n]);
        }
    }
}
