package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_16194카드구매하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine()," ");
        int arr[] = new int [n];
        for(int i =0; i<n; i++){
            arr[i]= Integer.parseInt(s.nextToken());
        }
        int dp[] = new int [n+1];
        Arrays.fill(dp,123456789);
        dp[0]=0;
        dp[1]=arr[0];

        for(int i=2; i<=n ; i++){
            for(int j=1;j<=i;j++ ) {
                dp[i] = Math.min(dp[i-j]+arr[j-1],dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
