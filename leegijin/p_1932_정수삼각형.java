import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        //5
        //7
        //3 8
        //8 1 0
        //2 7 4 4
        //4 5 2 6 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int [n][n];
        for(int i =0 ; i< n ; i++){
            StringTokenizer s = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<=i; j++){
                int m= Integer.parseInt(s.nextToken());
                arr[i][j]=m;
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for (int i=1; i< arr.length; i++) {

            dp[i][0] = arr[i][0] + dp[i - 1][0];

            for (int j=1; j<i+1; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        int max = 0;
        for (int i=0; i<dp[dp.length - 1].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        System.out.println(max);
    }
}
