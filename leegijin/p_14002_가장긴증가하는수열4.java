import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14002_가장긴증가하는수열4 {
    public static int dp[];
    public static int val[];
    public static int arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        val = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            val[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    val[i] = j;
                }
            }
        }
        for(int tmp : val){
            System.out.println(tmp);
        }
        int max = 0;
        int lastIdx = 0;
        for (int i = 0; i < dp.length; i++) {
            // System.out.print(dp[i] + " ");
            if (max < dp[i]) {
                max = dp[i];
                lastIdx = i;
            }

        }
        System.out.println(max);
        System.out.println(go(lastIdx));

    }

    public static String go(int p) {
        if (p == -1) {
            return "";
        }
        return go(val[p])+ arr[p]+" ";
    }

}
