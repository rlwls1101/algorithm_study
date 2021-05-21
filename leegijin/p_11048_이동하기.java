import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11048_이동하기 {
    //3 4
    //1 2 3 4
    //0 0 0 5
    //9 8 7 6


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine()," ");
        //n 과 m 이 1000개인걸로 봐서 불가능하다.
        //dp 로 가는것이 맞다고 생각
        int n = atom(s.nextToken());
        int m = atom(s.nextToken());
        int arr[][] = new int [n+1][m+1];
        for(int i =1; i<=n; i++){
            s = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=m; j++){
                arr[i][j]=atom(s.nextToken());
            }
        }
        int dp[][] = new int [1001][1001]; //현재 위치를 포함한 가장 큰값

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
                }
            }
            System.out.println(dp[n][m]);
        }
      /* for(int [] tmp: arr){
            for(int t: tmp){
                System.out.print(t+" ");
            }
            System.out.println();
        }*/
    static int atom(String s){
        return Integer.parseInt(s);
    }
}
