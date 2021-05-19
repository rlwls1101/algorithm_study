import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_1699_제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long dp[] = new long [100001];
        Arrays.fill(dp,123456789);
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=1 ; i<=n ; i++){
            for(int j=1; j<=Math.sqrt(i) ; j++){
                dp[i]= Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
