import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11053_가장긴증가하는수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int [n];
        for(int i =0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int dp[] = new int [n];
        int answer= 1;
        dp[0]=1;
        for(int i =1; i<n ; i++){
            int max=1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    max =Math.max(dp[j]+1,max);
                }
            }
            dp[i]=max;
            answer = Math.max(answer,max);
        }
        System.out.println(answer);
    }
}
