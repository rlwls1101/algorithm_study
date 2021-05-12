package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int dp[] = new int[10000001];
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        for(int i=4; i<=n; i++){
            int tmp1 =123456789;
            int tmp2 =123456789;
            if(i%3==0){
                tmp1 = dp[i/3]+1;
            }
            if(i%2==0){
                tmp2 = dp[i/2]+1;
            }
            dp[i]=Math.min(Math.min(tmp1,tmp2),dp[i-1]+1);
        }
        System.out.println(dp[n]);
    }
}
