import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2225_합분해 {
    //0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
    //
    //덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(s.nextToken());
        int k = Integer.parseInt(s.nextToken());

        int dp[][] = new int[n+1][k+1];

        for(int i=1;i<=n;i++) {
            dp[i][1]=1;
        }

        for(int i=1;i<=k;i++) {
            dp[1][i]=i;
        }


        for(int i=2;i<=n;i++) {
            for(int j=2;j<=k;j++) {
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
            }
        }
        System.out.println(dp[n][k]%1000000000);
    }
}

